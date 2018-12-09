package booking.hotel.services;

import booking.hotel.Booking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseService {
    private static final Logger LOG = LoggerFactory.getLogger(ResponseService.class);

    public void sendSuccess(AsyncContext asyncContext, Booking booking) {
        LOG.info("Send success response {} ", booking);
        ((HttpServletResponse) asyncContext.getResponse()).setStatus(200);
        try {
            PrintWriter outputStream = asyncContext.getResponse().getWriter();
            outputStream.println("hotel booked ");
            outputStream.println(booking.getInput());
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            asyncContext.complete();
        }
    }

    public void sendError(AsyncContext asyncContext, String errorMessage) {
        LOG.info("Send error response {}", errorMessage);
        ((HttpServletResponse) asyncContext.getResponse()).setStatus(503);

        try {
            PrintWriter outputStream = asyncContext.getResponse().getWriter();
            outputStream.println(errorMessage);
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            asyncContext.complete();
        }
    }
}
