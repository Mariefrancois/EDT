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
public class Salle implements Model_JDBC {
    private int id;
    private String nom;
    private int capacite;
    
    public Salle (String nom, int capacite){
        this.nom= nom;
        this.capacite = capacite;
    }
    
    public Salle(int id) throws SQLException{
        ResultSet rs = BD_MySQL.executer_requete("SELECT * FROM Salle WHERE id="+id);
        rs.next();
        this.id = rs.getInt("id");
        this.nom = rs.getString("nom");
        this.capacite = rs.getInt("capacite");
    }

    public int getId() {
        return id;
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
     * @return the capacite
     */
    public int getCapacite() {
        return capacite;
    }

    /**
     * @param capacite the capacite to set
     */
    public void setCapacite(int capacite) {
        this.capacite = capacite;
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
    
}
