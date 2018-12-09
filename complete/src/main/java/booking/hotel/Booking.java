package booking.hotel;

import org.immutables.value.Value;

import java.util.Map;

@Value.Immutable
public interface Booking {

    Map<String, String> getInput();

    default String getHotelName(){
        return "";
    }

}
