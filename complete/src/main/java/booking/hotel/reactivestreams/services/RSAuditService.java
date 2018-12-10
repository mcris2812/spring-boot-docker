package booking.hotel.reactivestreams.services;

import booking.hotel.Booking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.function.Function;
import java.util.logging.Level;

import static reactor.core.publisher.SignalType.*;

public class RSAuditService implements Function<Booking, Mono<Booking>> {
    private static final Logger LOG = LoggerFactory.getLogger(RSAuditService.class);

    @Override
    public Mono<Booking> apply(Booking booking) {
        LOG.info("Auditing... {} ", booking);
        return Mono.just(booking).log("", Level.ALL, true, ON_COMPLETE);
    }
}
