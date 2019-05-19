package fr.descartes.cvvensample.dao;

import Others.Type_Evenement;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Table evenement
 * @author CHINOISERIZ
 */
@Entity
@Table(name = "evenement")
public class Evenement implements Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int num_evenement;
    
    private String intitule_evenement;
    private String theme_evenement;
    private LocalDate dateDebut_evenement;
    private float duree_evenement;
    private int nbPartMax_evenement;
    private String description_evenement;
    private String organisateur_evenement;
    private Type_Evenement type_evenement;
    
    @OneToMany(mappedBy = "evenement")
    private List<Participant> participants = new ArrayList();

    public Evenement(String intitule_evenement, String theme_evenement, LocalDate dateDebut_evenement, float duree_evenement, int nbPartMax_evenement, String description_evenement, String organisateur_evenement, Type_Evenement type_evenement) {
        this.intitule_evenement = intitule_evenement;
        this.theme_evenement = theme_evenement;
        this.dateDebut_evenement = dateDebut_evenement;
        this.duree_evenement = duree_evenement;
        this.nbPartMax_evenement = nbPartMax_evenement;
        this.description_evenement = description_evenement;
        this.organisateur_evenement = organisateur_evenement;
        this.type_evenement = type_evenement;
    }

    public Evenement() {
        this.intitule_evenement = "test";
    }

    // <editor-fold defaultstate="collapsed" desc="Getter - Setter">
    public int getNum_evenement() {
        return num_evenement;
    }

    public void setNum_evenement(int num_evenement) {
        this.num_evenement = num_evenement;
    }

    public String getIntitule_evenement() {
        return intitule_evenement;
    }

    public void setIntitule_evenement(String intitule_evenement) {
        this.intitule_evenement = intitule_evenement;
    }

    public String getTheme_evenement() {
        return theme_evenement;
    }

    public void setTheme_evenement(String theme_evenement) {
        this.theme_evenement = theme_evenement;
    }

    public LocalDate getDateDebut_evenement() {
        return dateDebut_evenement;
    }

    public void setDateDebut_evenement(LocalDate dateDebut_evenement) {
        this.dateDebut_evenement = dateDebut_evenement;
    }

    public float getDuree_evenement() {
        return duree_evenement;
    }

    public void setDuree_evenement(float duree_evenement) {
        this.duree_evenement = duree_evenement;
    }

    public int getNbPartMax_evenement() {
        return nbPartMax_evenement;
    }

    public void setNbPartMax_evenement(int nbPartMax_evenement) {
        this.nbPartMax_evenement = nbPartMax_evenement;
    }

    public String getDescription_evenement() {
        return description_evenement;
    }

    public void setDescription_evenement(String description_evenement) {
        this.description_evenement = description_evenement;
    }

    public String getOrganisateur_evenement() {
        return organisateur_evenement;
    }

    public void setOrganisateur_evenement(String organisateur_evenement) {
        this.organisateur_evenement = organisateur_evenement;
    }

    public Type_Evenement getType_evenement() {
        return type_evenement;
    }

    public void setType_evenement(Type_Evenement type_evenement) {
        this.type_evenement = type_evenement;
    }
    // </editor-fold>

}
