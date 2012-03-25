/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edt.Classe;


/**
 *
 * @author Marie
 */
public class Salle {
    private Long id;
    private String nom;
    private int capacite;

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
     * @return the capacite
     */
    public int getCapacite() {
        return capacite;
    }

    /**
     * @param capacite the capacite to set
     */
    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }
    
}
