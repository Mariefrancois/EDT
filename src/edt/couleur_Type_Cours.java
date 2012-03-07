/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edt;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.awt.Color;

/**
 *
 * @author Marie
 */
@Entity
public class couleur_Type_Cours implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomCouleur;
    private Color couleurTexte;
    private Color couleurFond;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof couleur_Type_Cours)) {
            return false;
        }
        couleur_Type_Cours other = (couleur_Type_Cours) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edt.couleur_Type_Cours[ id=" + id + " ]";
    }

    /**
     * @return the nomCouleur
     */
    public String getNomCouleur() {
        return nomCouleur;
    }

    /**
     * @param nomCouleur the nomCouleur to set
     */
    public void setNomCouleur(String nomCouleur) {
        this.nomCouleur = nomCouleur;
    }

    /**
     * @return the couleurTexte
     */
    public Color getCouleurTexte() {
        return couleurTexte;
    }

    /**
     * @param couleurTexte the couleurTexte to set
     */
    public void setCouleurTexte(Color couleurTexte) {
        this.couleurTexte = couleurTexte;
    }

    /**
     * @return the couleurFond
     */
    public Color getCouleurFond() {
        return couleurFond;
    }

    /**
     * @param couleurFond the couleurFond to set
     */
    public void setCouleurFond(Color couleurFond) {
        this.couleurFond = couleurFond;
    }
    
}
