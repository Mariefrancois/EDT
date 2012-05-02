/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edt.Classe;

import edt.mysql.BD_MySQL;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author v-tech_master
 */
public class Option implements Model_JDBC{
    private int id;
    private String nom;
    private String valeur;
    
    public Option(String nom, String valeur){
        this.id = 0;
        this.nom = nom;
        this.valeur = valeur;
    }
    
    public Option(int id) throws SQLException{
        ResultSet rs = BD_MySQL.executer_requete("SELECT * FROM Option WHERE id="+id);
        rs.next();
        this.id = rs.getInt("id");
        this.nom = rs.getString("nom");
        this.valeur = rs.getString("valeur");
    }

    /**
     * @return the id
     */
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
     * @return the valeur
     */
    public String getValeur() {
        return valeur;
    }

    /**
     * @param valeur the valeur to set
     */
    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    @Override
    public void save() {
        String requete;
        
        if(this.id == 0){
            requete = "INSERT INTO Option (nom, valeur) "
                    + "VALUES ('"+this.nom
                    +"', '"+this.valeur
                    +"')";
        }else{
            requete = "UPDATE Option SET "
                    + "nom='"+this.nom
                    +"', valeur='"+this.valeur
                    +"' WHERE id='"+this.id+"'";
        }
        
        this.id = BD_MySQL.executer_update(requete);
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public static String valeurFromNom(String nom) throws SQLException {
        ResultSet rs = BD_MySQL.executer_requete("SELECT valeur FROM Option WHERE nom='" + nom + "';");
        rs.next();
        return rs.getString("nom");
    }
}
