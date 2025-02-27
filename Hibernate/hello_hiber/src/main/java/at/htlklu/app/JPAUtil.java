package at.htlklu.app;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    private static EntityManagerFactory emf;
    private static EntityManager em;

    public static EntityManager getEntityManager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("people");
        }
        if (em == null) {
            em = emf.createEntityManager();
        }
        return em;
    }
    public static void shutdown() {
        if (em != null && em.isOpen()) {
            em.close();
        }
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
        em = null;
        emf = null;
    }
}
