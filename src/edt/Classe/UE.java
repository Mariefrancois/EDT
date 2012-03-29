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
public class UE implements Model_JDBC {
    private int id;
    private String nom;
    private String intitule;
    private int nbHeuresCours;
    private int nbHeuresTD;
    private int nbHeuresTP;
    private int ECTS;
    
    public UE(String nom, String intitule, int nbHeuresCours, int nbHeuresTD, int nbHeuresTP, int ECTS){
        this.nom = nom;
        this.intitule = intitule;
        this.nbHeuresCours = nbHeuresCours;
        this.nbHeuresTD = nbHeuresTD;
        this.nbHeuresTP = nbHeuresTP;
        this.ECTS = ECTS;
    }

    public UE(int id) throws SQLException{
        ResultSet rs = BD_MySQL.executer_requete("SELECT * FROM UE WHERE id="+id);
        rs.next();
        this.id = rs.getInt("id");
        this.nom = rs.getString("nom");
        this.intitule = rs.getString("intitule");
        this.nbHeuresCours = rs.getInt("nbHeuresCours");
        this.nbHeuresTD = rs.getInt("nbHeuresTD");
        this.nbHeuresTP = rs.getInt("nbHeuresTP");
        this.ECTS = rs.getInt("ECTS");
    }
    
    public int getId() {
        return id;
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

    @Override
    public void insert() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
