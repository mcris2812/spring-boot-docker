package booking.hotel.completablefuture;


import booking.hotel.ImmutableBooking;
import booking.hotel.ResponseService;
import booking.hotel.completablefuture.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class StartFlowCF {
    private static final Logger LOG = LoggerFactory.getLogger(StartFlowCF.class);

    private final AuditService audit;
    private final ValidationService validate;
    private final BookingService bookHotel;
    private final AccountService getAccount;
    private final PaymentService payBooking;
    private final ResponseService sendResponse;

    public StartFlowCF(AuditService audit,
                       ValidationService validate,
                       BookingService bookHotel,
                       AccountService getAccount,
                       PaymentService payBooking,
                       ResponseService sendResponse) {
        this.audit = audit;
        this.validate = validate;
        this.bookHotel = bookHotel;
        this.getAccount = getAccount;
        this.payBooking = payBooking;
        this.sendResponse = sendResponse;
    }

    public void start(HttpServletRequest request) {
        AsyncContext asyncContext = request.startAsync();
        asyncContext.setTimeout(30000);

        LOG.info("Starting.. {} ", StartFlowCF.class.getName());
        Map<String, String> data = Map.of("key", "value");
        ImmutableBooking bookingData = ImmutableBooking.builder().input(data).build();

        CompletableFuture
                .supplyAsync(() -> bookingData)
                .thenApply(audit)
                .thenApply(validate)
                .thenAccept((validationResult -> {
                    if (validationResult.isValid()) {
                        CompletableFuture
                                .completedFuture(bookingData)
                                .thenCompose(bookHotel)
                                .thenCombine(CompletableFuture
                                        .completedFuture(bookingData)
                                        .thenCompose(getAccount), payBooking)
                                .thenAccept(completedBooking -> completedBooking
                                        .thenAccept(successBooking ->
                                                sendResponse.sendSuccess(asyncContext, successBooking)));


                    } else {
                        sendResponse.sendError(asyncContext, "input validation error");
                    }
                }

                ))
                .exceptionally(throwable ->
                        {
                            sendResponse.sendError(asyncContext, throwable.getMessage());
                            return null;
                        }
                );
    }
}
