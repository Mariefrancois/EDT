/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edt.Classe;


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
  //  @OneToMany(mappedBy = "Creneau_Intervenant", cascade = {CascadeType.ALL})
  //  private Set<Creneau_Intervenant> creneau_inter = new HashSet<Creneau_Intervenant>(); 
    

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
    
}
