package de.dhbw.studienarbeit.sqllernsoftware.persistence;

import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Lektion;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

public class AppdataController {
    private static final Logger logger = Logger.getLogger("de.dhbw.studienarbeit.sqllernsoftware.persistence.AppdataController");

    public static EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("de.dhbw.studienarbeit.sqllernsoftware.appdata");
        return emf.createEntityManager();
    }

    public Lektion getLektionById(Long id) {
        Query jpqlQuery = getEntityManager().createQuery("SELECT l FROM Lektion l WHERE l.id=:id");
        jpqlQuery.setParameter("id", id);
        return (Lektion) jpqlQuery.getSingleResult();
    }

    public List<Lektion> getAllLektion() {
        TypedQuery<Lektion> jpqlQuery = getEntityManager().createQuery("SELECT l FROM Lektion l", Lektion.class);
        return jpqlQuery.getResultList();
    }

}
