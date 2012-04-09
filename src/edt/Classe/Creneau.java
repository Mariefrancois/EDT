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
    
    private long id;
    private String nom;
    private int duree;
    private long idType_Cours;
    private long idSalle;
    private long idIntervenant;
    private long idUE;
    
    public Creneau (String nom, int duree, long idType_Cours, long idSalle, long idIntervenant, long idUE){
        this.id = 0;
        this.nom = nom;
        this.duree = duree;
        this.idType_Cours = idType_Cours;
        this.idSalle = idSalle;
        this.idIntervenant = idIntervenant;
        this.idUE = idUE;
    }
    
    public Creneau(long id) throws SQLException{
        ResultSet rs = BD_MySQL.executer_requete("SELECT * FROM Creneau WHERE id="+id);
        rs.next();
        this.id = rs.getLong("id");
        this.nom = rs.getString("nom");
        this.duree = rs.getInt("duree");
        this.idType_Cours = rs.getLong("idType_Cours");
        this.idSalle = rs.getLong("idSalle");
        this.idIntervenant = rs.getLong("idIntervenant");
        this.idUE = rs.getLong("idUE");
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
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
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
    public long getIdType_Cours() {
        return idType_Cours;
    }

    /**
     * @param idType_Cours the idType_Cours to set
     */
    public void setIdType_Cours(long idType_Cours) {
        this.idType_Cours = idType_Cours;
    }

    /**
     * @return the idSalle
     */
    public long getIdSalle() {
        return idSalle;
    }

    /**
     * @param idSalle the idSalle to set
     */
    public void setIdSalle(long idSalle) {
        this.idSalle = idSalle;
    }

    /**
     * @return the idIntervenant
     */
    public long getIdIntervenant() {
        return idIntervenant;
    }

    /**
     * @param idIntervenant the idIntervenant to set
     */
    public void setIdIntervenant(long idIntervenant) {
        this.idIntervenant = idIntervenant;
    }

    /**
     * @return the idUE
     */
    public long getIdUE() {
        return idUE;
    }

    /**
     * @param idUE the idUE to set
     */
    public void setIdUE(long idUE) {
        this.idUE = idUE;
    }
    
}
