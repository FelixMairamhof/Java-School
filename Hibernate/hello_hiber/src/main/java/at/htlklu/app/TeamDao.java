package at.htlklu.app;


import at.htlklu.model.Team;
import jakarta.persistence.EntityManager;

import java.util.List;


public class TeamDao {

    public static void createTeam(Team team) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(team);
        em.getTransaction().commit();
    }
    public static Team getTeamById(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        Team team = em.find(Team.class, id);
        return team;
    }
    public static void updateTeam(Team team) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(team);
        em.getTransaction().commit();
    }
    public static List<Team> getAllTeams() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Team> teams = em.createQuery("from Team ").getResultList();
        return teams;
    }
    public static List<Team> getByStadium(String name) {
        EntityManager em = JPAUtil.getEntityManager();
        List<Team> teams = em.createQuery("from Team team where team.stadium=:name", Team.class)
                .setParameter("name", name)
                .getResultList();
        return teams;

    }

    public static void deleteTeam(Team team) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(em.contains(team) ? team : em.merge(team));
        em.getTransaction().commit();

    }
/*    public static void updatePerson(Person person) {
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
    }*/
}

