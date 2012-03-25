/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edt.Classe;


/**
 *
 * @author Marie
 */
public class Groupe_Etudiants {
    private Long id;
    private String nom;
    private String identifiant;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the identifiant
     */
    public String getIdentifiant() {
        return identifiant;
    }

    /**
     * @param identifiant the identifiant to set
     */
    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }
    
}
