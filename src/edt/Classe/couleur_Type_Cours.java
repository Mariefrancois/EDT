/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edt.Classe;

import java.awt.Color;

/**
 *
 * @author Marie
 */
public class couleur_Type_Cours {
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
