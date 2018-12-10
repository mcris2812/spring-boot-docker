package booking.hotel.completablefuture.services;

import booking.hotel.Booking;
import booking.hotel.ImmutableValidationResult;
import booking.hotel.ValidationResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

public class ValidationService implements Function<Booking, ValidationResult> {
    private static final Logger LOG = LoggerFactory.getLogger(ValidationService.class);

    @Override
    public ValidationResult apply(Booking booking) {
        LOG.info("Validating ... {} ", booking);
        return ImmutableValidationResult.builder().isValid(true).build();
    }
}
