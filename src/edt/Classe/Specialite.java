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
public class Specialite {
    private Long id;
    private String nom;
    private String intitule;
    
    public Specialite(int id) throws SQLException{
        ResultSet rs = BD_MySQL.executer_requete("SELECT * FROM Specialite WHERE id="+id);
        rs.next();
        this.id = rs.getLong("id");
        this.nom = rs.getString("nom");
        this.intitule = rs.getString("intitule");
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
    
}
