package at.htlklu.app;

import at.htlklu.model.Person;
import at.htlklu.model.Player;
import at.htlklu.model.Team;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {

        System.out.println("------------- APP START -------------");

        Team team = TeamDao.getTeamById(2);
        System.out.println(team);
//        List<Player> players = PlayerDao.getAllPlayers();
//        players.forEach(p -> System.out.println(p.getFirstname()));
//
//        Player p = PlayerDao.getPlayerById(4);
//        System.out.println(p.getFirstname());

 /*     Team team = new Team("Mavericks", "Dallas", "DalasCenter");
        TeamDao.createTeam(team);*/

/*        Team blazers = TeamDao.getTeamById(1);
        System.out.println(blazers);*/

/*        blazers.setCity("Oregon City");
        TeamDao.updateTeam(blazers);*/

        //TeamDao.getAllTeams().forEach(System.out::println);

/*        TeamDao.getByStadium("Oregon").forEach(System.out::println);*/

/*        TeamDao.deleteTeam(blazers);*/
        //-----------------Person-----------------
/*        Person felipe = new Person("Owezara", 75.0, LocalDate.now().minusYears(18));
        PersonDao.createPerson(felipe);

        felipe.setWeight(84.5);
        PersonDao.updatePerson(felipe);

        Person ferdi = PersonDao.getPersonById(3);
        PersonDao.deletePerson(ferdi);


        Person cindy = PersonDao.getPersonById(2);
        System.out.println(cindy);

        PersonDao.getAllPersons().forEach(System.out::println);

        PersonDao.getPersonsByName(cindy.getName()).forEach(System.out::println);*/

        JPAUtil.shutdown();
    }
}
