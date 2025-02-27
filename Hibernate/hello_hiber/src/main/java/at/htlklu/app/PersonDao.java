package at.htlklu.app;

import at.htlklu.model.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class PersonDao {
    public static void createPerson(Person person) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("people");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        em.close();
    }
    public static void updatePerson(Person person) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("people");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
        em.close();
    }
    public static void deletePerson(Person person) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("people");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.contains(person) ? person : em.merge(person));
        em.getTransaction().commit();
        em.close();
    }
    public static Person getPersonById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("people");
        EntityManager em = emf.createEntityManager();
        Person person = em.find(Person.class, id);
        em.close();
        return person;
    }
    public static List<Person> getAllPersons() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("people");
        EntityManager em = emf.createEntityManager();
        List<Person> persons = em.createQuery("from Person").getResultList();
        em.close();
        return persons;
    }
    public static List<Person> getPersonsByName(String name) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("people");
        EntityManager em = emf.createEntityManager();
        List<Person> persons = em.createQuery("from Person person where person.name=:name", Person.class)
                .setParameter("name", name)
                .getResultList();
        em.close();
        return persons;
    }
}
