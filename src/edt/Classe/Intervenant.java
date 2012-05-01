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
public class Intervenant implements Model_JDBC {
    private int id;
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
    
    public Intervenant(int id) throws SQLException{
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
    
    public static String nomIntervenant(int id) throws SQLException{
         BD_MySQL.init();
         String requete = "SELECT nom , prenom FROM Intervenant WHERE id="+id+" ORDER BY  email, telephone, notificationsactives, actif;";
         ResultSet rs = BD_MySQL.executer_requete(requete);
         rs.next();
         return rs.getString("nom")+" "+rs.getString("prenom");
    }
    
    public static ArrayList<Integer> liste_id_Intervenant() throws SQLException{
        BD_MySQL.init();
        ArrayList<Integer> liste_id_Intervenant = new ArrayList();
        String requete = "SELECT id FROM Intervenant ORDER BY nom, prenom, email;";
        ResultSet rs = BD_MySQL.executer_requete(requete);
        while(rs.next()){
            liste_id_Intervenant.add(rs.getInt("id"));
        }
        return liste_id_Intervenant;
    }
    
    public static int id_Intervenant(String nom, String nomPrenom, String email) throws SQLException{
        BD_MySQL.init();
        String requete = "SELECT id FROM Intervenant WHERE nom='"+nom+"' AND prenom='"+nomPrenom+"' AND email='"+email+"';";
        ResultSet rs = BD_MySQL.executer_requete(requete);
        rs.next();
        return rs.getInt("id");
    }
    public static int id_Intervenant(String nom, String nomPrenom){
            BD_MySQL.init();
            int id = 0;
        try {
            String requete = "SELECT id FROM Intervenant WHERE nom='"+nom+"' AND prenom='"+nomPrenom+"';";
            ResultSet rs = BD_MySQL.executer_requete(requete);
            rs.next();
            id = rs.getInt("id");
        } catch (SQLException ex) {
            Logger.getLogger(Intervenant.class.getName()).log(Level.SEVERE, null, ex);
        }
            return id;
    }
    public static ArrayList<String> list_nom_Intervenant() {
        ArrayList<Intervenant> list_Intervenant = null;
        try {
            list_Intervenant = liste_Intervenant();
        } catch (SQLException ex) {
            Logger.getLogger(UE.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<String> liste_nom_Intervenant = new ArrayList();
        for (Intervenant l : list_Intervenant) {
                liste_nom_Intervenant.add(l.getNom()+" "+l.getPrenom());
            }
        return liste_nom_Intervenant;
    }
    
    public static ArrayList<Intervenant> liste_Intervenant() throws SQLException{
        ArrayList<Intervenant> liste_intervenant = new ArrayList();
        ArrayList<Integer> liste_id_intervenant = liste_id_Intervenant();
        for (int l : liste_id_intervenant) {
            liste_intervenant.add(new Intervenant(l));
        }
        return liste_intervenant;
    }
}
