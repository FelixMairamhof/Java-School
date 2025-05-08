package app;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.Order;

import java.util.List;

public class OrderDAO {

    public Order getOrderById(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        return em.find(Order.class, id);
    }

    public List<Order> getAllOrders() {
        EntityManager em = JPAUtil.getEntityManager();
        return em.createQuery("from Order", Order.class).getResultList();
    }

    public void createOrder(Order order) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(order);
        transaction.commit();
    }

    public void updateOrder(Order order) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(order);
        transaction.commit();
    }

    public void deleteOrder(Order order) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(em.contains(order) ? order : em.merge(order));
        transaction.commit();
    }
    // In OrderDAO.java
    public void deleteAllOrders() {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.createQuery("DELETE FROM Order").executeUpdate();
        transaction.commit();
    }
}