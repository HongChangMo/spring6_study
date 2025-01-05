package tobyspring.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// Component Scan을 통해 Bean 정보를 가져올때 사용, Class에 Component 어노테이션으로 지정되어있는 Class를 scan 한다.
@ComponentScan
public class ObjectFactory {
    /*@Bean
    public PaymentService paymentService() {
        return new PaymentService(exRateProvider());
    }

    @Bean
    public ExRateProvider exRateProvider() {
        return new SimpleExRateProvider();
    }*/
}
