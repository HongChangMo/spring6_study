package tobyspring.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tobyspring.hellospring.exrate.CachedExRateProvider;
import tobyspring.hellospring.payment.ExRateProvider;
import tobyspring.hellospring.exrate.WebApiExRateProvider;
import tobyspring.hellospring.payment.PaymentService;

@Configuration
// Component Scan을 통해 Bean 정보를 가져올때 사용, Class에 Component 어노테이션으로 지정되어있는 Class를 scan 한다.
//@ComponentScan
public class ObjectFactory {
    @Bean
    public PaymentService paymentService() {
        return new PaymentService(exRateProvider());
    }

    @Bean
    public OrderService orderService() {
        return new OrderService(exRateProvider());
    }
    @Bean
    public ExRateProvider exRateProvider() {
        return new WebApiExRateProvider();
    }

    /*@Bean
    public ExRateProvider cachedExRateProvider() {
        return new CachedExRateProvider( exRateProvider() );
    }*/
}

class OrderService {
    ExRateProvider exRateProvider;

    public OrderService(ExRateProvider exRateProvider) {
        this.exRateProvider = exRateProvider;
    }
}
