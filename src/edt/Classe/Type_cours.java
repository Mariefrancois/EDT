/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edt.Classe;

import edt.mysql.BD_MySQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Marie
 */
public class Type_cours implements Model_JDBC {
    
    private int id;
    private String nom;
    
    public Type_cours(String nom){
        this.id = 0;
        this.nom = nom;
    }
    
    public Type_cours(Long id) throws SQLException{
        ResultSet rs = BD_MySQL.executer_requete("SELECT * FROM Type_Cours WHERE id="+id);
        rs.next();
        this.id = rs.getInt("id");
        this.nom = rs.getString("nom");
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

    @Override
    public void save() {
        String requete;
        
        if(this.id == 0){
            requete = "INSERT INTO Type_Cours (nom) "
                    + "VALUES ('"+this.nom
                    +"')";
        }else{
            requete = "UPDATE Type_Cours SET "
                    + "nom='"+this.nom
                    +"' WHERE id='"+this.id+"'";
        }
        
        this.id = BD_MySQL.executer_update(requete);
    }

    @Override
    public void delete() {
         String requete;   

        requete = "DELETE FROM Type_Cours "
                +" WHERE id='"+this.id+"';";
        
        this.id = BD_MySQL.executer_update(requete);
    }
    
    public static String nomType_cours(int id){
            String nom ="";
        try {
            String requete = "SELECT nom FROM Type_Cours WHERE id="+id+" ";
            ResultSet rs = BD_MySQL.executer_requete(requete);
            rs.next();
            nom = rs.getString("nom");
        } catch (SQLException ex) {
            Logger.getLogger(Type_cours.class.getName()).log(Level.SEVERE, null, ex);
        }
            return nom;
    }
    
    public static ArrayList<String> listeNomType_cours() {
        ArrayList<String> liste = new ArrayList();
        try {
            String requete = "SELECT nom FROM Type_Cours ORDER BY nom;";
            ResultSet rs = BD_MySQL.executer_requete(requete);
            while (rs.next()) {
                liste.add(rs.getString("nom"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Type_cours.class.getName()).log(Level.SEVERE, null, ex);
        }
        return liste;
    }
    
}
