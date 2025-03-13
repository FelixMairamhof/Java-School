package at.htlklu.app;

import at.htlklu.model.Player;
import jakarta.persistence.EntityManager;

import java.util.List;

public class PlayerDao {

    public static Player getPlayerById(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        Player player = em.find(Player.class, id);
        return player;
    }

    public static List<Player> getAllPlayers() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Player> players = em.createQuery("from Player", Player.class).getResultList();
        return players;
    }

    public static void createPlayer(Player player) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(player);
        em.getTransaction().commit();
    }

    public static void updatePlayer(Player player) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(player);
        em.getTransaction().commit();
    }

    public static List<Player> getPlayersByTeamId(int teamId) {
        EntityManager em = JPAUtil.getEntityManager();
        List<Player> players = em.createQuery("from Player player where player.team.id = :teamId", Player.class)
                .setParameter("teamId", teamId)
                .getResultList();
        return players;
    }

    public static void deletePlayer(Player player) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(em.contains(player) ? player : em.merge(player));
        em.getTransaction().commit();
    }
}