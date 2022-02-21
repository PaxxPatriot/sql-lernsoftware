package de.dhbw.studienarbeit.sqllernsoftware.persistence;

import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabenkollektion;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Lektion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Logger;

public class AppdataController {
    private static final Logger logger = Logger.getLogger("de.dhbw.studienarbeit.sqllernsoftware.persistence.AppdataController");

    private static EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("de.dhbw.studienarbeit.sqllernsoftware.appdata");
        return emf.createEntityManager();
    }

    public Lektion getLektionById(Long id) {
        TypedQuery<Lektion> jpqlQuery = getEntityManager().createQuery("SELECT l FROM Lektion l WHERE l.id=:id", Lektion.class);
        jpqlQuery.setParameter("id", id);
        return jpqlQuery.getSingleResult();
    }

    public List<Lektion> getAllLektion() {
        TypedQuery<Lektion> jpqlQuery = getEntityManager().createQuery("SELECT l FROM Lektion l", Lektion.class);
        return jpqlQuery.getResultList();
    }

    public Aufgabenkollektion getAufgabenkollektionById(String id) {
        TypedQuery<Aufgabenkollektion> jpqlQuery = getEntityManager().createQuery("SELECT a FROM Aufgabenkollektion a WHERE a.id=:id", Aufgabenkollektion.class);
        jpqlQuery.setParameter("id", id);
        return jpqlQuery.getSingleResult();
    }

    public List<Aufgabenkollektion> getAllAufgabenkollektion() {
        TypedQuery<Aufgabenkollektion> jpqlQuery = getEntityManager().createQuery("SELECT a FROM Aufgabenkollektion a", Aufgabenkollektion.class);
        return jpqlQuery.getResultList();
    }
}
