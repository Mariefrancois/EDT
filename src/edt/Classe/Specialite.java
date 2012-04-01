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
public class Specialite implements Model_JDBC {
    private int id;
    private String nom;
    private String intitule;
    
    public Specialite(String nom, String intitule){
        this.id = 0;
        this.nom = nom;
        this.intitule = intitule;
    }
    
    public Specialite(int id) throws SQLException{
        ResultSet rs = BD_MySQL.executer_requete("SELECT * FROM Specialite WHERE id="+id);
        rs.next();
        this.id = rs.getInt("id");
        this.nom = rs.getString("nom");
        this.intitule = rs.getString("intitule");
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

    @Override
    public void save() {
        String requete;
        
        if(this.id == 0){
            requete = "INSERT INTO Specialite (nom, intitule) "
                    + "VALUES ('"+this.nom
                    +"', '"+this.intitule
                    +"')";
        }else{
            requete = "UPDATE Specialite SET "
                    + "nom='"+this.nom
                    +"', intitule='"+this.intitule
                    +"' WHERE id='"+this.id+"'";
        }
        
        this.id = BD_MySQL.executer_update(requete);
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
