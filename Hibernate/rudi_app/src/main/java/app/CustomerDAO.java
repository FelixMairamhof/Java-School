package app;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.Customer;

import java.util.List;

public class CustomerDAO {

    public Customer getCustomerById(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        return em.find(Customer.class, id);
    }

    public List<Customer> getAllCustomers() {
        EntityManager em = JPAUtil.getEntityManager();
        return em.createQuery("from Customer", Customer.class).getResultList();
    }

    public void createCustomer(Customer customer) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(customer);
        transaction.commit();
    }

    public void updateCustomer(Customer customer) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(customer);
        transaction.commit();
    }

    public void deleteCustomer(Customer customer) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(em.contains(customer) ? customer : em.merge(customer));
        transaction.commit();
    }
    // In CustomerDAO.java
    public void deleteAllCustomers() {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.createQuery("DELETE FROM Order").executeUpdate(); // Delete all orders first
        em.createQuery("DELETE FROM Customer").executeUpdate();
        transaction.commit();
    }
}