package booking.hotel.reactivestreams.services;

import booking.hotel.AccountDetails;
import booking.hotel.Booking;
import booking.hotel.ImmutableAccountDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

public class RSAccountService implements Function<Booking, AccountDetails> {
    private static final Logger LOG = LoggerFactory.getLogger(RSAccountService.class);

    @Override
    public AccountDetails apply(Booking booking) {
        LOG.info("Get Account ...{}", booking);
        AccountDetails accountDetails = ImmutableAccountDetails.builder().accountNumber(1).build();
        return accountDetails;
//        return Mono
//                .just(accountDetails)
//                .log("", Level.ALL, true, SignalType.ON_COMPLETE);
    }
}
