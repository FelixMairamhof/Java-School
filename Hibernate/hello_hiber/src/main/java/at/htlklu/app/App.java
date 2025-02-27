package at.htlklu.app;

import at.htlklu.model.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {

        Person felipe = new Person("Owezara", 75.0, LocalDate.now().minusYears(18));
        PersonDao.createPerson(felipe);

        felipe.setWeight(84.5);
        PersonDao.updatePerson(felipe);

        Person ferdi = PersonDao.getPersonById(3);
        PersonDao.deletePerson(ferdi);


        Person cindy = PersonDao.getPersonById(2);
        System.out.println(cindy);

        PersonDao.getAllPersons().forEach(System.out::println);

        PersonDao.getPersonsByName(cindy.getName()).forEach(System.out::println);

        JPAUtil.shutdown();
    }
}
