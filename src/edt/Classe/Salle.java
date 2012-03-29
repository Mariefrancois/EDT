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
    private int idBatiment;
    
    
    public Salle(String nom, int capacite,int idBatiment){
        this.id = 0;
        this.nom = nom;
        this.capacite = capacite;
        this.idBatiment = idBatiment;
    }
    
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
        this.idBatiment = rs.getInt("idBatiment");
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

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }
    
     /**
     * @return the idBatiment
     */
    public int getIdBatiment() {
        return idBatiment;
    }

    /**
     * @param idBatiment the idBatiment to set
     */
    public void setIdBatiment(int idBatiment) {
        this.idBatiment = idBatiment;
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
        final Salle other = (Salle) obj;
        if (this.id != other.id) {
            return false;
        }
        if ((this.nom == null) ? (other.nom != null) : !this.nom.equals(other.nom)) {
            return false;
        }
        if (this.capacite != other.capacite) {
            return false;
        }
        if (this.getIdBatiment() != other.getIdBatiment()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 97 * hash + (this.nom != null ? this.nom.hashCode() : 0);
        hash = 97 * hash + this.capacite;
        hash = 97 * hash + this.getIdBatiment();
        return hash;
    }
}
