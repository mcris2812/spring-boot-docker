package booking.hotel.reactivestreams;


import booking.hotel.Booking;
import booking.hotel.ImmutableBooking;
import booking.hotel.ResponseService;
import booking.hotel.reactivestreams.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class StartFlowRS {
    private static final Logger LOG = LoggerFactory.getLogger(StartFlowRS.class);

    private final RSAuditService audit;
    private final RSValidationService validate;
    private final RSBookingService bookHotel;
    private final RSAccountService getAccount;
    private final RSPaymentService payBooking;
    private final ResponseService sendResponse;

    public StartFlowRS(RSAuditService audit,
                       RSValidationService validate,
                       RSBookingService bookHotel,
                       RSAccountService getAccount,
                       RSPaymentService payBooking,
                       ResponseService sendResponse) {
        this.audit = audit;
        this.validate = validate;
        this.bookHotel = bookHotel;
        this.getAccount = getAccount;
        this.payBooking = payBooking;
        this.sendResponse = sendResponse;
    }

    void start(HttpServletRequest request) {
        LOG.info("Starting ... {} ", StartFlowRS.class.getName());
        AsyncContext asyncContext = request.startAsync();
        asyncContext.setTimeout(30000);

        Map<String, String> data = Map.of("key", "value");
        Booking bookingData = ImmutableBooking.builder().input(data).build();


        Mono
                .just(bookingData)
                .flatMap(audit)
                .flatMap(validate)
                .map(validationResult -> {
                            if (validationResult.isValid()) {
                                  Mono
                                          .just(bookingData)
                                          .flatMap(bookHotel)
                                          .zipWith(Mono
                                                  .just(bookingData)
                                                  .map(getAccount),
                                                  payBooking)
                                          .subscribe(successBooking -> sendResponse.sendSuccess(asyncContext, successBooking));
                            } else {
                                sendResponse.sendError(asyncContext, "input validation error");
                            }
                            return null;
                        }
                )
                .subscribe();


    }
}
