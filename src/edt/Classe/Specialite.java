/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edt.Classe;


/**
 *
 * @author Marie
 */
public class Specialite {
    private Long id;
    private String nom;
    private String intitule;

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
     * @return the intitule
     */
    public String getIntitule() {
        return intitule;
    }

    /**
     * @param intitule the intitule to set
     */
    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }
    
}
