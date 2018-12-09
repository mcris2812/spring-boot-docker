package booking.hotel.services;

import booking.hotel.AccountDetails;
import booking.hotel.Booking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;

public class PaymentService implements BiFunction<Booking, AccountDetails, CompletableFuture<Booking>> {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentService.class);

    @Override
    public CompletableFuture<Booking> apply(Booking booking, AccountDetails accountDetails) {
        LOG.info("Paying ... {}", booking);
        return CompletableFuture.completedFuture(booking);
    }
}
