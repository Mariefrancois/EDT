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
    private Long id;
    private String type;
    private Timestamp tsDebut;
    private Timestamp tsFin;
    
    public Cours(int id) throws SQLException{
        ResultSet rs = BD_MySQL.executer_requete("SELECT * FROM Cours WHERE id="+id);
        rs.next();
        this.id = rs.getLong("id");
        this.type = rs.getString("type");
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
    
}
