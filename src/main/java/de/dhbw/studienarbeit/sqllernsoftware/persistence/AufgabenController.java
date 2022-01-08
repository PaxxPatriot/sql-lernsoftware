package de.dhbw.studienarbeit.sqllernsoftware.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.logging.Logger;

public class AufgabenController {
    private static final Logger logger = Logger.getLogger("de.dhbw.studienarbeit.sqllernsoftware.persistence.AufgabenController");

    public static EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("de.dhbw.studienarbeit.sqllernsoftware.appdata");
        return emf.createEntityManager();
    }
}