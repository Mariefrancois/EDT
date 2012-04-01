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
public class Groupe_Administratif implements Model_JDBC {
    private int id;
    private String nom;
    
    public Groupe_Administratif(String nom){
        this.id = 0;
        this.nom = nom;
    }
    
    public Groupe_Administratif(int id) throws SQLException{
        ResultSet rs = BD_MySQL.executer_requete("SELECT * FROM Groupe_Administratif WHERE id="+id);
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
            requete = "INSERT INTO Groupe_Administratif (nom) "
                    + "VALUES ('"+this.nom
                    +"')";
        }else{
            requete = "UPDATE Groupe_Administratif SET "
                    + "nom='"+this.nom
                    +"' WHERE id='"+this.id+"'";
        }
        
        this.id = BD_MySQL.executer_update(requete);
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
