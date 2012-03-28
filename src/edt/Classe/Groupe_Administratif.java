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
public class Groupe_Administratif {
    private Long id;
    private String nom;
    
    public Groupe_Administratif(int id) throws SQLException{
        ResultSet rs = BD_MySQL.executer_requete("SELECT * FROM Groupe_Administratif WHERE id="+id);
        rs.next();
        this.id = rs.getLong("id");
        this.nom = rs.getString("nom");
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
    
}
