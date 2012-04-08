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
public class Intervenant implements Model_JDBC {
    private long id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private boolean notificationsactives;
    private boolean actif;
    
    public Intervenant(String nom, String prenom, String email, String telephone, boolean notif, boolean actif){
        this.id = 0;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.notificationsactives = notif;
        this.actif = actif;
    }
    
    public Intervenant(long id) throws SQLException{
        ResultSet rs = BD_MySQL.executer_requete("SELECT * FROM Intervenant WHERE id="+id);
        rs.next();
        this.id = rs.getInt("id");
        this.nom = rs.getString("nom");
        this.prenom = rs.getString("prenom");
        this.email = rs.getString("email");
        this.telephone = rs.getString("telephone");
        this.notificationsactives = rs.getBoolean("notificationsactives");
        this.actif = rs.getBoolean("actif");
    }
    

    public long getId() {
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public boolean getNotificationsactives() {
        return notificationsactives;
    }

    public void setNotificationsactives(boolean notificationsactives) {
        this.notificationsactives = notificationsactives;
    }

    public boolean getActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    @Override
    public void save() {
        String requete;
        
        if(this.getId() == 0){
            requete = "INSERT INTO Intervenant (nom, prenom, email, telephone, notificationsactives, actif) "
                    + "VALUES ('"+this.nom
                    +"', '"+this.prenom
                    +"', '"+this.email
                    +"', '"+this.telephone
                    +"', "+this.notificationsactives
                    +", "+this.actif
                    +");";
        }else{
            requete = "UPDATE Intervenant SET "
                    + "nom='"+this.nom
                    +"', prenom='"+this.prenom
                    +"', email='"+this.email
                    +"', telephone='"+this.telephone
                    +"', notificationsactives="+this.notificationsactives
                    +", idTypeCours="+this.actif
                    +" WHERE id="+this.getId()+";";
        }
        
        this.id = BD_MySQL.executer_update(requete);
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
