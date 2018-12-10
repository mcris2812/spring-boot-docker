package booking.hotel.completablefuture.services;

import booking.hotel.Booking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class BookingService implements Function<Booking, CompletableFuture<Booking>> {
    private static final Logger LOG = LoggerFactory.getLogger(BookingService.class);

    @Override
    public CompletableFuture<Booking> apply(Booking booking) {
        LOG.info("Booking ... {} ", booking);
        return CompletableFuture.completedFuture(booking);
    }
}
