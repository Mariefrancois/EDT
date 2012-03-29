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
public class Intervenant implements Model_JDBC {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String notificationsactives;
    private boolean actif;
  //  @OneToMany(mappedBy = "Creneau_Intervenant", cascade = {CascadeType.ALL})
  //  private Set<Creneau_Intervenant> creneau_inter = new HashSet<Creneau_Intervenant>(); 
    
    public Intervenant(String nom, String prenom, String email, String telephone, String notif, boolean actif){
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.notificationsactives = notif;
        this.actif = actif;
    }
    
    public Intervenant(Long id) throws SQLException{
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
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone the telephone to set
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * @return the notificationsactives
     */
    public String getNotificationsactives() {
        return notificationsactives;
    }

    /**
     * @param notificationsactives the notificationsactives to set
     */
    public void setNotificationsactives(String notificationsactives) {
        this.notificationsactives = notificationsactives;
    }

    /**
     * @return the actif
     */
    public boolean getActif() {
        return actif;
    }

    /**
     * @param actif the actif to set
     */
    public void setActif(boolean actif) {
        this.actif = actif;
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
