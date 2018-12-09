package booking.hotel.services;

import booking.hotel.AccountDetails;
import booking.hotel.Booking;
import booking.hotel.ImmutableAccountDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class AccountService implements Function<Booking, CompletableFuture<AccountDetails>> {
    private static final Logger LOG = LoggerFactory.getLogger(AccountService.class);

    @Override
    public CompletableFuture<AccountDetails> apply(Booking booking) {
        LOG.info("Get Account ...{}", booking);
        ImmutableAccountDetails accountDetails = ImmutableAccountDetails.builder().accountNumber(1).build();
        return CompletableFuture.completedFuture(accountDetails);
    }
}
