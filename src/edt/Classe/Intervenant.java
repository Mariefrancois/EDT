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
public class Intervenant {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String notificationsactives;
    private boolean actif;
    
    public Intervenant(int id) throws SQLException{
        ResultSet rs = BD_MySQL.executer_requete("SELECT * FROM Intervenant WHERE id="+id);
        rs.next();
        this.id = rs.getLong("id");
        this.nom = rs.getString("nom");
        this.prenom = rs.getString("prenom");
        this.email = rs.getString("email");
        this.telephone = rs.getString("telephone");
        this.notificationsactives = rs.getString("notificationsactives");
        this.actif = rs.getBoolean("actif");
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getNotificationsactives() {
        return notificationsactives;
    }

    public void setNotificationsactives(String notificationsactives) {
        this.notificationsactives = notificationsactives;
    }

    public boolean getActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }
    
}
