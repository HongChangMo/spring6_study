package tobyspring.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import tobyspring.hellospring.exrate.RestTemplateExRateProvider;
import tobyspring.hellospring.order.OrderService;
import tobyspring.hellospring.payment.ExRateProvider;
import tobyspring.hellospring.payment.PaymentService;

import java.time.Clock;

@Configuration
// Component Scan을 통해 Bean 정보를 가져올때 사용, Class에 Component 어노테이션으로 지정되어있는 Class를 scan 한다.
//@ComponentScan
public class PaymentConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(new JdkClientHttpRequestFactory());
    }
    @Bean
    public PaymentService paymentService() {
        return new PaymentService(exRateProvider(), clock());
    }

   /* @Bean
    public OrderService orderService() {
        return new OrderService(exRateProvider());
    }*/
    @Bean
    public ExRateProvider exRateProvider() {
        return new RestTemplateExRateProvider(restTemplate());
    }

    @Bean
    public Clock clock() {
        return Clock.systemDefaultZone();
    }

    /*@Bean
    public ExRateProvider cachedExRateProvider() {
        return new CachedExRateProvider( exRateProvider() );
    }*/
}
/*
class OrderService {
    ExRateProvider exRateProvider;

    public OrderService(ExRateProvider exRateProvider) {
        this.exRateProvider = exRateProvider;
    }
}*/
