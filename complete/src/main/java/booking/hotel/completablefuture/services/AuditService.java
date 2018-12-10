package booking.hotel.completablefuture.services;

import booking.hotel.Booking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.UnaryOperator;

public class AuditService implements UnaryOperator<Booking> {
    private static final Logger LOG = LoggerFactory.getLogger(AuditService.class);

    @Override
    public Booking apply(Booking booking) {
        LOG.info("Auditing... {} ", booking);
        return booking;
    }
}
