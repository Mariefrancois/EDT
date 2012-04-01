/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edt.Classe;

import edt.mysql.BD_MySQL;
import java.security.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Marie
 */
public class Cours implements Model_JDBC {
    private int id;
    private Timestamp tsDebut;
    private Timestamp tsFin;
    private int idUE;
    private int idSalle;
    private int idIntervenant;
    private int idTypeCours;
    
    public Cours(Timestamp tsDebut, Timestamp tsFin, int idUE, int idSalle, int idIntervenant, int idTypeCours){
        this.id = 0;
        this.tsDebut = tsDebut;
        this.tsFin = tsFin;
        this.idUE = idUE;
        this.idSalle = idSalle;
        this.idIntervenant = idIntervenant;
        this.idTypeCours = idTypeCours;
    }
    
    public Cours(int id) throws SQLException{
        ResultSet rs = BD_MySQL.executer_requete("SELECT * FROM Cours WHERE id="+id);
        rs.next();
        this.id = rs.getInt("id");
        //this.tsDebut = (Timestamp) rs.getString("tsDebut");
        //this.tsFin = rs.getString("tsFin");
        this.idUE = rs.getInt("idUE");
        this.idSalle = rs.getInt("idSalle");
        this.idIntervenant = rs.getInt("idIntervenant");
        this.idTypeCours = rs.getInt("idTypeCours");
    }

  /**
     * @return the id
     */
    public int getId() {
        return id;
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
     * @return the idTypeCours
     */
    public int getIdTypeCours() {
        return idTypeCours;
    }

    /**
     * @param idTypeCours the idTypeCours to set
     */
    public void setIdTypeCours(int idTypeCours) {
        this.idTypeCours = idTypeCours;
    }
    
     @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cours other = (Cours) obj;
        if (this.getId() != other.getId()) {
            return false;
        }
        if (this.getIdUE() != other.getIdUE()) {
            return false;
        }
        if (this.getIdSalle() != other.getIdSalle()) {
            return false;
        }
        if (this.getIdIntervenant() != other.getIdIntervenant()) {
            return false;
        }
        if (this.getIdTypeCours() != other.getIdTypeCours()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (int) (this.getId() ^ (this.getId() >>> 32));
        hash = 97 * hash + this.getIdUE();
        hash = 97 * hash + this.idSalle;
        hash = 97 * hash + this.getIdIntervenant();
        hash = 97 * hash + this.getIdTypeCours();
        return hash;
    }

    @Override
    public void save() {
        String requete;
        
        if(this.getId() == 0){
            requete = "INSERT INTO Cours (tsDebut, tsFin, idUE, idSalle, idIntervenant, idTypeCours) "
                    + "VALUES ('"+this.getTsDebut()
                    +"', '"+this.tsFin
                    +"', '"+this.idUE
                    +"', '"+this.idSalle
                    +"', '"+this.idIntervenant
                    +"', '"+this.idTypeCours
                    +"')";
        }else{
            requete = "UPDATE Cours SET "
                    + "tsDebut='"+this.tsDebut
                    +"', tsFin='"+this.tsFin
                    +"', idUE='"+this.idUE
                    +"', idSalle='"+this.idSalle
                    +"', idIntervenant='"+this.idIntervenant
                    +"', idTypeCours='"+this.idTypeCours
                    +"' WHERE id='"+this.getId()+"'";
        }
        
        this.id = BD_MySQL.executer_update(requete);
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

  
}
