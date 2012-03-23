/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edt;

/**
 *
 * @author Marie
 */
public class Etudiant  {
    private Long id;
    private int numeroEtudiant;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String notificationsActives;

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    /**
     * @return the numeroEtudiant
     */
    public int getNumeroEtudiant() {
        return numeroEtudiant;
    }

    /**
     * @param numeroEtudiant the numeroEtudiant to set
     */
    public void setNumeroEtudiant(int numeroEtudiant) {
        this.numeroEtudiant = numeroEtudiant;
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
     * @return the notificationsActives
     */
    public String getNotificationsActives() {
        return notificationsActives;
    }

    /**
     * @param notificationsActives the notificationsActives to set
     */
    public void setNotificationsActives(String notificationsActives) {
        this.notificationsActives = notificationsActives;
    }
    
}
