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
public class Groupe_Cours {
    private Long id;
    private String nom;
    private String identifiant;

    public Groupe_Cours(int id) throws SQLException{
        ResultSet rs = BD_MySQL.executer_requete("SELECT * FROM Groupe_Cours WHERE id="+id);
        rs.next();
        this.id = rs.getLong("id");
        this.nom = rs.getString("nom");
        this.identifiant = rs.getString("identifiant");
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
     * @return the identifiant
     */
    public String getIdentifiant() {
        return identifiant;
    }

    /**
     * @param identifiant the identifiant to set
     */
    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }
    
}
