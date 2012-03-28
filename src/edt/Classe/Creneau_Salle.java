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
public class Creneau_Salle {
    private Long id;
    private Timestamp tsDebut;
    private Timestamp tsFin;

    public Creneau_Salle(int id) throws SQLException{
        ResultSet rs = BD_MySQL.executer_requete("SELECT * FROM Creneau_Salle WHERE id="+id);
        rs.next();
        this.id = rs.getLong("id");
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
