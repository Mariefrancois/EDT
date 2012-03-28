/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edt.Classe;

import java.security.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Marie
 */
public class Cours {
    private long id;
    private Timestamp tsDebut;
    private Timestamp tsFin;
    private int idUE;
    private int idSall;
    private int idIntervenant;
    private int idTypeCours;
    
    
    public Cours(Timestamp tsDebut, Timestamp tsFin,int idUE,int idSall,int idIntervenant,int idTypeCours){
        this.id = 0;
        this.tsDebut = tsDebut;
        this.tsFin = tsFin;
        this.idUE = idUE;
        this.idSall = idSall;
        this.idIntervenant = idIntervenant;
        this.idTypeCours = idTypeCours;
    }
    public Cours(int id) throws SQLException{
        ResultSet rs = BD_MySQL.executer_requete("SELECT * FROM Cours WHERE id="+id);
        rs.next();
        this.id = rs.getLong("id");
       // this.tsDebut = rs.getString("tsDebut");
       // this.tsFin = rs.getString("tsFin");
        this.idUE = rs.getInt("idUE");
        this.idSall = rs.getInt("idSall");
        this.idIntervenant = rs.getInt("idIntervenant");
        this.idTypeCours = rs.getInt("idTypeCours");
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
     * @return the idSall
     */
    public int getIdSall() {
        return idSall;
    }

    /**
     * @param idSall the idSall to set
     */
    public void setIdSall(int idSall) {
        this.idSall = idSall;
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
        if (this.id != other.id) {
            return false;
        }
        if (this.idUE != other.idUE) {
            return false;
        }
        if (this.idSall != other.idSall) {
            return false;
        }
        if (this.idIntervenant != other.idIntervenant) {
            return false;
        }
        if (this.idTypeCours != other.idTypeCours) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 97 * hash + this.idUE;
        hash = 97 * hash + this.idSall;
        hash = 97 * hash + this.idIntervenant;
        hash = 97 * hash + this.idTypeCours;
        return hash;
    }
}
