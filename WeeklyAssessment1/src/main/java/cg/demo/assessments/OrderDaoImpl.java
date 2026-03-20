package cg.demo.assessments;

import jakarta.persistence.*;
import java.util.List;

import cg.demo.entitites.Customer;
import cg.demo.entitites.Order;

public class OrderDaoImpl implements OrderDao {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
    private EntityManager em = emf.createEntityManager();

    @Override
    public boolean addOrder(Order order, int custId) {

        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Customer cust = em.find(Customer.class, custId);

            if (cust == null) {
                tx.rollback();
                return false;
            }

            order.setCustomer(cust);
            em.persist(order);

            tx.commit();
            return true;
        }
        catch (Exception e) {

            if (tx.isActive()) {
                tx.rollback();
            }

            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Order getOrder(int id) {
        return em.find(Order.class, id);
    }

    @Override
    public List<Order> getOrders(String name) {

        String jpql = "SELECT o FROM Order o WHERE o.customer.customerName = :cname";

        TypedQuery<Order> query = em.createQuery(jpql, Order.class);
        query.setParameter("cname", name);

        return query.getResultList();
    }
}