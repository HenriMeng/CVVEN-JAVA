package fr.descartes.cvvensample.services;

import fr.descartes.cvvensample.dao.Evenement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

public class EvenementService {

    private final SessionFactory sessionFactory;

    public EvenementService(SessionFactory sessionFactory) {
        this.sessionFactory = Objects.requireNonNull(sessionFactory);
    }

    /**
     * Méthode permettant d'insérer un {@link Evenement} en base de données.
     *
     * @param evenement Objet {@link Evenement} devant être inséré en base de
     * données.
     */
    public void insertEvenement(Evenement evenement) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(evenement);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Méthode permettant d'obtenir tous les {@link Evenement} présents en base
     * de données.
     *
     * @return Une liste d'objets {@link Evenement}.
     */
    public List<Evenement> getAllEvenement() {
        List<Evenement> test = new ArrayList();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List evenements = session.createQuery("FROM Evenement").list();
        for (Evenement evenement : (List<Evenement>) evenements) {
//            System.out.println("Evenement (" + evenement.getIntitule_evenement() + ")");
            test.add(evenement);
        }
        session.getTransaction().commit();
        session.close();
        return test;
    }

    /**
     * Méthode permettant de mettre à jour un {@link Evenement}.
     *
     * @param evenement Un {@link Evenement} présent en base de données qui doit
     * être mis à jour.
     */
    public void updateEvenement(Evenement evenement) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(evenement);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Méthode permettant de supprimer un {@link Evenement} en base de données.
     *
     * @param evenement Un objet {@link Evenement} présent en base de données.
     */
    public void deleteEvenement(Evenement evenement) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(evenement);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Méthode permettant de supprimer un {@link Evenement} identifié par son id
     * en base de données.
     *
     * @param numEvenement Numéro de l'{@link Evenement} à supprimer en base de
     * données.
     */
    public void deleteEvenement(int numEvenement) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List evenements = session.createQuery("from evenement").list();
        for (Evenement evenement : (List<Evenement>) evenements) {
            if (evenement.getNum_evenement() == numEvenement) {
                session.delete(evenement);
            }
        }
        session.getTransaction().commit();
        session.close();
    }
}