/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edt;

import java.sql.Timestamp;
/**
 *
 * @author Marie
 */
public class Promotion {
    private Long id;
    private String nom;
    private int annee;
    private Timestamp tsDebut;
    private Timestamp tsFin;
    

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
     * @return the annee
     */
    public int getAnnee() {
        return annee;
    }

    /**
     * @param annee the annee to set
     */
    public void setAnnee(int annee) {
        this.annee = annee;
    }

    /**
     * @return the tsDebut
     */
    public Timestamp getTsDebut() {
        return tsDebut;
    }

    /**
     * @param tsDebut the tsDebut to set
     */
    public void setTsDebut(Timestamp tsDebut) {
        this.tsDebut = tsDebut;
    }

    /**
     * @return the tsFin
     */
    public Timestamp getTsFin() {
        return tsFin;
    }

    /**
     * @param tsFin the tsFin to set
     */
    public void setTsFin(Timestamp tsFin) {
        this.tsFin = tsFin;
    }
    
}
