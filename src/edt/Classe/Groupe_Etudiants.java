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
 * @author Marie
 */
public class Groupe_Etudiants implements Model_JDBC {
    private int id;
    private String nom;
    private String identifiant;
    
    public Groupe_Etudiants (String nom, String identifiant){
        this.id = 0;
        this.nom = nom;
        this.identifiant = identifiant;
    }

    public Groupe_Etudiants(int id) throws SQLException{
        ResultSet rs = BD_MySQL.executer_requete("SELECT * FROM Groupe_Etudiants WHERE id="+id);
        rs.next();
        this.id = rs.getInt("id");
        this.nom = rs.getString("nom");
        this.identifiant = rs.getString("identifiant");
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

    @Override
    public void save() {
        String requete;
        
        if(this.id == 0){
            requete = "INSERT INTO Groupe_Etudiants (nom, identifiant) "
                    + "VALUES ('"+this.nom
                    +"', '"+this.identifiant
                    +"')";
        }else{
            requete = "UPDATE Groupe_Etudiants SET "
                    + "nom='"+this.nom
                    +"', identifiant='"+this.identifiant
                    +"' WHERE id='"+this.id+"'";
        }
        
        this.id = BD_MySQL.executer_update(requete);
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
