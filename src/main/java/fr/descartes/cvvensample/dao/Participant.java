package fr.descartes.cvvensample.dao;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Table participant
 * @author CHINOISERIZ
 */
@Entity
@Table(name = "participant")
public class Participant implements Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int num_participant;
    private String nom_participant;
    private String prenom_participant;
    private String email_participant;
    private LocalDate datenaiss_participant;
    @ManyToOne
    private Evenement evenement;

    public Participant(String nom_participant, String prenom_participant, String email_participant, LocalDate datenaiss_participant, Evenement evenement) {
        this.nom_participant = nom_participant;
        this.prenom_participant = prenom_participant;
        this.email_participant = email_participant;
        this.datenaiss_participant = datenaiss_participant;
        this.evenement = evenement;
    }

    public Participant() {
        this.nom_participant = "test";
    }

    // <editor-fold defaultstate="collapsed" desc="Getter - Setter">
    public int getNum_participant() {
        return num_participant;
    }

    public void setNum_participant(int num_participant) {
        this.num_participant = num_participant;
    }

    public String getNom_participant() {
        return nom_participant;
    }

    public void setNom_participant(String nom_participant) {
        this.nom_participant = nom_participant;
    }

    public String getPrenom_participant() {
        return prenom_participant;
    }

    public void setPrenom_participant(String prenom_participant) {
        this.prenom_participant = prenom_participant;
    }

    public String getEmail_participant() {
        return email_participant;
    }

    public void setEmail_participant(String email_participant) {
        this.email_participant = email_participant;
    }

    public LocalDate getDatenaiss_participant() {
        return datenaiss_participant;
    }

    public void setDatenaiss_participant(LocalDate datenaiss_participant) {
        this.datenaiss_participant = datenaiss_participant;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }
    // </editor-fold>

}
