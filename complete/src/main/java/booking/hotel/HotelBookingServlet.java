package booking.hotel;

import booking.hotel.completablefuture.StartFlowCF;
import booking.hotel.reactivestreams.StartFlowRS;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HotelBookingServlet extends HttpServlet {
    private final StartFlowCF startFlowCF;
    private final StartFlowRS startFlowRS;

    public HotelBookingServlet(StartFlowCF startFlowCF, StartFlowRS startFlowRS) {
        this.startFlowCF = startFlowCF;
        this.startFlowRS = startFlowRS;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        startFlowCF.start(req);
    }
}
