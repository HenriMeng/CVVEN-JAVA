package fr.descartes.cvvensample;

import fr.descartes.cvvensample.dao.Evenement;
import fr.descartes.cvvensample.services.EvenementService;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import swing.EvenementsPage;

public class Application {

    public static void main(String[] args) {
        // Open session
        SessionFactory sessionFactory = createSessionFactory();
        if (sessionFactory == null) {
            System.out.println("Il y a un problème, sessionFactory = null");
        }

        
        EvenementsPage testpage = new EvenementsPage(sessionFactory);

        // Close session
        //closeSessionFactory(sessionFactory);
    }

    /**
     * Mise en place d'une SessionFactory
     *
     * @return
     */
    private static SessionFactory createSessionFactory() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        try {
            SessionFactory sessionFactory = new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();
            return sessionFactory;
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
            System.out.println(e);
        }
        return null;
    }

    /**
     * Fermer une SessionFactory
     *
     * @param sessionFactory
     */
    private static void closeSessionFactory(SessionFactory sessionFactory) {
        sessionFactory.close();
    }

}
