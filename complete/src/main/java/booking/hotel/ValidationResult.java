package booking.hotel;

import org.immutables.value.Value;

@Value.Immutable
public interface ValidationResult {

    boolean isValid();
}
