package booking.hotel.completablefuture;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StartFlowCF {
    private static final Logger LOG = LoggerFactory.getLogger(StartFlowCF.class);


    public  void start(HttpServletRequest request, HttpServletResponse response) {
        LOG.info("Starting.. {} ", StartFlowCF.class.getName() );

    }
}
