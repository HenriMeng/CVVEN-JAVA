package fr.descartes.cvvensample.services;

import fr.descartes.cvvensample.dao.Evenement;
import java.util.List;
import java.util.Objects;
import org.hibernate.SessionFactory;
import fr.descartes.cvvensample.dao.Participant;
import java.util.ArrayList;
import org.hibernate.Session;

public class ParticipantService {

    private SessionFactory sessionFactory;

    public ParticipantService(SessionFactory sessionFactory) {
        this.sessionFactory = Objects.requireNonNull(sessionFactory);
    }

    /**
     * Méthode permettant d'insérer un {@link Participant} en base de données.
     *
     * @param Participant Objet {@link Participant} devant être inséré en base
     * de données.
     */
    public void insertParticipant(Participant participant) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(participant);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Méthode permettant d'obtenir tous les {@link Participant} présents en
     * base de données.
     *
     * @return Une liste d'objets {@link Participant}.
     */
    public List<Participant> getAllParticipant() {        
        List<Participant> test = new ArrayList();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List participants = session.createQuery("FROM Participant").list();
        for (Participant participant : (List<Participant>) participants) {
            test.add(participant);
        }
        session.getTransaction().commit();
        session.close();
        return test;
    }

    /**
     * Méthode permettant de mettre à jour un {@link Participant}.
     *
     * @param Participant Un {@link Participant} présent en base de données qui
     * doit être mis à jour.
     */
    public void updateParticipant(Participant participant) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(participant);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Méthode permettant de supprimer un {@link Participant} en base de
     * données.
     *
     * @param Participant Un objet {@link Participant} présent en base de
     * données.
     */
    public void deleteParticipant(Participant participant) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(participant);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Méthode permettant de supprimer un {@link Participant} identifié par son
     * id en base de données.
     *
     * @param numParticipant Numéro du {@link Participant} à supprimer en base
     * de données.
     */
    public void deleteParticipant(int numParticipant) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List participants = session.createQuery("from evenement").list();
        for (Participant participant : (List<Participant>) participants) {
            if (participant.getNum_participant() == numParticipant) {
                session.delete(participant);
            }
        }
        session.getTransaction().commit();
        session.close();
    }

}
