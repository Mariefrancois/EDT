/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edt.Classe;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Marie
 */
public class UE{
    private Long id;
    private String nom;
    private String intitule;
    private int nbHeuresCours;
    private int nbHeuresTD;
    private int nbHeuresTP;
    private int ECTS;

    public UE(int id) throws SQLException{
        ResultSet rs = BD_MySQL.executer_requete("SELECT * FROM UE WHERE id="+id);
        rs.next();
        this.id = rs.getLong("id");
        this.nom = rs.getString("nom");
        this.intitule = rs.getString("intitule");
        this.nbHeuresCours = rs.getInt("nbHeuresCours");
        this.nbHeuresTD = rs.getInt("nbHeuresTD");
        this.nbHeuresTP = rs.getInt("nbHeuresTP");
        this.ECTS = rs.getInt("ECTS");
    }
    
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

    /**
     * @return the nbHeuresCours
     */
    public int getNbHeuresCours() {
        return nbHeuresCours;
    }

    /**
     * @param nbHeuresCours the nbHeuresCours to set
     */
    public void setNbHeuresCours(int nbHeuresCours) {
        this.nbHeuresCours = nbHeuresCours;
    }

    /**
     * @return the nbHeuresTD
     */
    public int getNbHeuresTD() {
        return nbHeuresTD;
    }

    /**
     * @param nbHeuresTD the nbHeuresTD to set
     */
    public void setNbHeuresTD(int nbHeuresTD) {
        this.nbHeuresTD = nbHeuresTD;
    }

    /**
     * @return the nbHeuresTP
     */
    public int getNbHeuresTP() {
        return nbHeuresTP;
    }

    /**
     * @param nbHeuresTP the nbHeuresTP to set
     */
    public void setNbHeuresTP(int nbHeuresTP) {
        this.nbHeuresTP = nbHeuresTP;
    }

    /**
     * @return the ECTS
     */
    public int getECTS() {
        return ECTS;
    }

    /**
     * @param ECTS the ECTS to set
     */
    public void setECTS(int ECTS) {
        this.ECTS = ECTS;
    }
    
}
