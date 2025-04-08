package tobyspring.hellospring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tobyspring.hellospring.order.Order;
import tobyspring.hellospring.order.OrderService;
import tobyspring.hellospring.order.OrderServiceImpl;

import java.math.BigDecimal;

public class OrderClient {
    public static void main(String[] args) {

        BeanFactory beanFactory = new AnnotationConfigApplicationContext(OrderConfig.class);
        OrderService service = beanFactory.getBean(OrderService.class);

        Order order = service.createOrder("0100", BigDecimal.TEN);
        System.out.println(order);


        // 예외 실습용
        /*BeanFactory beanFactory = new AnnotationConfigApplicationContext(DataConfig.class);
        OrderRepository repository = beanFactory.getBean(OrderRepository.class);
        JpaTransactionManager transactionManager = beanFactory.getBean(JpaTransactionManager.class);

        try {
            // transaction begin
            new TransactionTemplate(transactionManager).execute( status -> {
                Order order = new Order("100", BigDecimal.TEN);
                repository.save(order);

                System.out.println(order);

                *//*Order order2 = new Order("100", BigDecimal.ONE);
                repository.save(order2);*//*

                return null;
            });
        } catch (DataIntegrityViolationException e) {
            System.out.println("주문번호 중복 복구 작업");

        }*/


        // transaction commit
    }
}
