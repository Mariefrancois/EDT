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
public class Cours implements Model_JDBC {
    private int id;
    private String type;
    private Timestamp tsDebut;
    private Timestamp tsFin;
    private int idUE;
    private int idSall;
    private int idIntervenant;
    private int idTypeCours;
    
    public Cours(String type, Timestamp tsDebut, Timestamp tsFin){
        this.type = type;
        this.tsDebut = tsDebut;
        this.tsFin = tsFin;
    }
    
    public Cours(int id) throws SQLException{
        ResultSet rs = BD_MySQL.executer_requete("SELECT * FROM Cours WHERE id="+id);
        rs.next();
        this.id = rs.getInt("id");
        this.type = rs.getString("type");
        //this.tsDebut = (Timestamp) rs.getString("tsDebut");
        //this.tsFin = rs.getString("tsFin");
    }

    public int getId() {
        return id;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
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
