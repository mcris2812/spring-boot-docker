package booking.hotel;

import booking.hotel.completablefuture.StartFlowCF;
import booking.hotel.reactivestreams.StartFlowRS;
import booking.hotel.completablefuture.services.*;
import booking.hotel.reactivestreams.services.*;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.feed.RssChannelHttpMessageConverter;

import javax.servlet.http.HttpServlet;

@Configuration
public class HotelConfig {

    @Bean
    public ServletRegistrationBean<HttpServlet> hotel() {
        ServletRegistrationBean<HttpServlet> servRegBean = new ServletRegistrationBean<>();
        servRegBean.setServlet(new HotelBookingServlet(startFlowCF(), startFlowRS()));
        servRegBean.addUrlMappings("/hotel");
        servRegBean.setLoadOnStartup(1);
        return servRegBean;
    }

    @Bean
    public StartFlowCF startFlowCF() {
        return new StartFlowCF(auditService(), validationService(), bookingService(), dbService(), paymentService(), responseService());
    }

    @Bean
    public StartFlowRS startFlowRS() {
        return new StartFlowRS(rsAuditService(), rsValidationService(), rsBookingService(), rsAccountService(), rsPaymentService(), responseService());
    }

    @Bean
    public BookingService bookingService() {
        return new BookingService();
    }

    public RSBookingService rsBookingService() { return new RSBookingService();}

    @Bean
    public AccountService dbService() {
        return new AccountService();
    }

    @Bean
    public RSAccountService rsAccountService() {
        return new RSAccountService();
    }

    @Bean
    public PaymentService paymentService() {
        return new PaymentService();
    }

    @Bean
    public RSPaymentService rsPaymentService() {
        return new RSPaymentService();
    }

    @Bean
    public ValidationService validationService() {
        return new ValidationService();
    }

    @Bean
    public RSValidationService rsValidationService() {
        return new RSValidationService();
    }

    @Bean
    public AuditService auditService() {
        return new AuditService();
    }

    @Bean
    public RSAuditService rsAuditService() {
        return new RSAuditService();
    }

    @Bean
    public ResponseService responseService() {
        return new ResponseService();
    }
}
