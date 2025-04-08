package tobyspring.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tobyspring.data.JdbcOrderRepository;
import tobyspring.hellospring.order.OrderRepository;
import tobyspring.hellospring.order.OrderService;
import tobyspring.hellospring.order.OrderServiceImpl;

import javax.sql.DataSource;

@Configuration
/* OrderConfig를 로딩할때, DataConfig에 등록된 Bean의 내용을 읽어옴 */
@Import(DataConfig.class)
@EnableTransactionManagement
public class OrderConfig {
    @Bean
    public OrderService orderService(PlatformTransactionManager transactionManager,
                                     OrderRepository orderRepository) {
        /*return new OrderServiceTxProxy(
                new OrderServiceImpl(orderRepository),
                transactionManager)*/
        return new OrderServiceImpl(orderRepository);
    }

    @Bean
    public OrderRepository orderRepository(DataSource dataSource) {
//        return new JpaOrderRepository();
        return new JdbcOrderRepository(dataSource);
    }
}
