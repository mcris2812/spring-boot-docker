package booking.hotel.reactivestreams.services;

import booking.hotel.Booking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SignalType;

import java.util.function.Function;
import java.util.logging.Level;

public class RSBookingService implements Function<Booking, Mono<Booking>> {
    private static final Logger LOG = LoggerFactory.getLogger(RSBookingService.class);

    @Override
    public Mono<Booking> apply(Booking booking) {
        LOG.info("Booking ... {} ", booking);
        return Mono
                .just(booking)
                .log("", Level.ALL, true, SignalType.ON_COMPLETE);
    }
}
