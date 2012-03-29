/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edt.Classe;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
/**
 *
 * @author Marie
 */
public class Promotion implements Model_JDBC {
    private Long id;
    private String nom;
    private int annee;
    private Timestamp tsDebut;
    private Timestamp tsFin;
    
    public Promotion(String nom, int annee, Timestamp tsDebut, Timestamp tsFin){
        this.nom = nom;
        this.annee = annee;
        this.tsDebut = tsDebut;
        this.tsFin = tsFin;
    }
    
    public Promotion(Long id) throws SQLException{
        ResultSet rs = BD_MySQL.executer_requete("SELECT * FROM Promotion WHERE id="+id);
        rs.next();
        this.id = rs.getLong("id");
        this.nom = rs.getString("nom");
        this.annee = rs.getInt("annee");
        //this.tsDebut = rs.getString("tsDebut");
        //this.tsFin = rs.getString("tsFin");
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
