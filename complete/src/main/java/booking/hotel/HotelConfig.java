package booking.hotel;

import booking.hotel.completablefuture.StartFlowCF;
import booking.hotel.reactivestreams.StartFlowRS;
import booking.hotel.services.BookingService;
import booking.hotel.services.DbService;
import booking.hotel.services.PaymentService;
import booking.hotel.services.ValidationService;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServlet;

@Configuration
public class HotelConfig {

    @Bean
    public ServletRegistrationBean<HttpServlet> hotel() {
        ServletRegistrationBean<HttpServlet> servRegBean = new ServletRegistrationBean<>();
        servRegBean.setServlet(new HotelBookingServlet(startFlowCF(), startFlowRS));
        servRegBean.addUrlMappings("/hotel");
        servRegBean.setLoadOnStartup(1);
        return servRegBean;
    }

    @Bean
    public StartFlowCF startFlowCF() {
        return new StartFlowCF();
    }

    @Bean
    public StartFlowRS startFlowRS() {
        return new StartFlowRS();
    }

    @Bean
    public BookingService bookingService() {
        return new BookingService();
    }

    @Bean
    public DbService dbService() {
        return new DbService();
    }

    @Bean
    public PaymentService paymentService() {
        return new PaymentService();
    }

    @Bean
    public ValidationService validationService() {
        return new ValidationService();
    }
}
