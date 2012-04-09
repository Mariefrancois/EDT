/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edt.Classe;

import edt.mysql.BD_MySQL;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Marie
 */
public class Creneau implements Model_JDBC {
    
    private int id;
    private String nom;
    private int duree;
    private int idType_Cours;
    private int idSalle;
    private int idIntervenant;
    private int idUE;
    
    public Creneau (String nom, int duree, int idType_Cours, int idSalle, int idIntervenant, int idUE){
        this.id = 0;
        this.nom = nom;
        this.duree = duree;
        this.idType_Cours = idType_Cours;
        this.idSalle = idSalle;
        this.idIntervenant = idIntervenant;
        this.idUE = idUE;
    }
    
    public Creneau(int id) throws SQLException{
        ResultSet rs = BD_MySQL.executer_requete("SELECT * FROM Creneau WHERE id="+id);
        rs.next();
        this.id = rs.getInt("id");
        this.nom = rs.getString("nom");
        this.duree = rs.getInt("duree");
        this.idType_Cours = rs.getInt("idType_Cours");
        this.idSalle = rs.getInt("idSalle");
        this.idIntervenant = rs.getInt("idIntervenant");
        this.idUE = rs.getInt("idUE");
    }
    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
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
     * @return the duree
     */
    public int getDuree() {
        return duree;
    }

    /**
     * @param duree the duree to set
     */
    public void setDuree(int duree) {
        this.duree = duree;
    }

    /**
     * @return the idType_Cours
     */
    public int getIdType_Cours() {
        return idType_Cours;
    }

    /**
     * @param idType_Cours the idType_Cours to set
     */
    public void setIdType_Cours(int idType_Cours) {
        this.idType_Cours = idType_Cours;
    }

    /**
     * @return the idSalle
     */
    public int getIdSalle() {
        return idSalle;
    }

    /**
     * @param idSalle the idSalle to set
     */
    public void setIdSalle(int idSalle) {
        this.idSalle = idSalle;
    }

    /**
     * @return the idIntervenant
     */
    public int getIdIntervenant() {
        return idIntervenant;
    }

    /**
     * @param idIntervenant the idIntervenant to set
     */
    public void setIdIntervenant(int idIntervenant) {
        this.idIntervenant = idIntervenant;
    }

    /**
     * @return the idUE
     */
    public int getIdUE() {
        return idUE;
    }

    /**
     * @param idUE the idUE to set
     */
    public void setIdUE(int idUE) {
        this.idUE = idUE;
    }
    
}
