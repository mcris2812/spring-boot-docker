package booking.hotel;

import booking.hotel.completablefuture.StartFlowCF;
import booking.hotel.reactivestreams.StartFlowRS;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HotelBookingServlet extends HttpServlet {
    private final StartFlowCF startFlowCF;
    private final StartFlowRS startFlowRS;

    public HotelBookingServlet(StartFlowCF startFlowCF, StartFlowRS startFlowRS) {
        this.startFlowCF = startFlowCF;
        this.startFlowRS = startFlowRS;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        startFlowCF.start(req, resp);

        PrintWriter outputStream = resp.getWriter();
        outputStream.print("hotel booked");
        outputStream.close();
    }
}
