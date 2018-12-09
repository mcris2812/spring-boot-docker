package booking.hotel.reactivestreams;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StartFlowRS {
    private static final Logger LOG = LoggerFactory.getLogger(StartFlowRS.class);

    void start(HttpServletRequest request, HttpServletResponse response) {
        LOG.info("Starting ... {} ", StartFlowRS.class.getName());
    }
}
