package booking.hotel.reactivestreams.services;

import booking.hotel.AccountDetails;
import booking.hotel.Booking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.BiFunction;

public class RSPaymentService implements BiFunction<Booking, AccountDetails, Booking> {
    private static final Logger LOG = LoggerFactory.getLogger(RSPaymentService.class);

    @Override
    public Booking apply(Booking booking, AccountDetails accountDetails) {
        LOG.info("Paying ... {}", booking);

        return booking;
//        return Mono
//                .just(booking)
//                .log("", Level.ALL, true, SignalType.ON_COMPLETE);
    }
}
