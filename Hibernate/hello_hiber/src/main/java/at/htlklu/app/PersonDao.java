package at.htlklu.app;

import at.htlklu.model.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class PersonDao {
    public static void createPerson(Person person) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
    }
    public static void updatePerson(Person person) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
    }
    public static void deletePerson(Person person) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(em.contains(person) ? person : em.merge(person));
        em.getTransaction().commit();

    }
    public static Person getPersonById(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        Person person = em.find(Person.class, id);
        return person;
    }
    public static List<Person> getAllPersons() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Person> persons = em.createQuery("from Person").getResultList();
        return persons;
    }
    public static List<Person> getPersonsByName(String name) {
        EntityManager em = JPAUtil.getEntityManager();
        List<Person> persons = em.createQuery("from Person person where person.name=:name", Person.class)
                .setParameter("name", name)
                .getResultList();
        return persons;
    }
}
