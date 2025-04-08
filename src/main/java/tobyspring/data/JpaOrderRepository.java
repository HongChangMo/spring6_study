package tobyspring.data;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import tobyspring.hellospring.order.Order;
import tobyspring.hellospring.order.OrderRepository;

/*
* 템플릿 만드는 연습해보기
* */
public class JpaOrderRepository implements OrderRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Order order) {
        entityManager.persist(order);
    }
}
