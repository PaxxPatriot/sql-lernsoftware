package de.dhbw.studienarbeit.sqllernsoftware.sql;

import de.dhbw.studienarbeit.sqllernsoftware.objekte.Lektion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.logging.Logger;

public class AppdataController {
    private static Logger logger = Logger.getLogger("de.dhbw.studienarbeit.sqllernsoftware.sql");

    public static EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("de.dhbw.studienarbeit.sqllernsoftware.appdata");
        return emf.createEntityManager();
    }

    public Lektion getLektionById(Long id) {
        Query jpqlQuery = getEntityManager().createQuery("SELECT l FROM Lektion l WHERE l.id=:id");
        jpqlQuery.setParameter("id", id);
        return (Lektion) jpqlQuery.getSingleResult();
    }

}
