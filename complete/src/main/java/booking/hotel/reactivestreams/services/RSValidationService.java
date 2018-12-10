package booking.hotel.reactivestreams.services;

import booking.hotel.Booking;
import booking.hotel.ImmutableValidationResult;
import booking.hotel.ValidationResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SignalType;

import java.util.function.Function;
import java.util.logging.Level;

public class RSValidationService implements Function<Booking, Mono<ValidationResult>> {
    private static final Logger LOG = LoggerFactory.getLogger(RSValidationService.class);

    @Override
    public Mono<ValidationResult> apply(Booking booking) {
        LOG.info("Validating ... {} ", booking);
        return Mono
                .just((ValidationResult) ImmutableValidationResult.builder().isValid(true).build())
                .log("", Level.ALL, true, SignalType.ON_COMPLETE);
    }
}
