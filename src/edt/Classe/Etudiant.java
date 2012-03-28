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
public class Etudiant  {
    
    private Long id;
    private int numeroEtudiant;
    private String prenom;
    private String nom;
    private String email;
    private String telephone;
    private boolean notificationsActives;
    private int idPromotion;
    private int idSpecialite;
    
    public Etudiant(int idEtudiant) throws SQLException{
        ResultSet rs = BD_MySQL.executer_requete("SELECT * FROM Etudiant WHERE id="+idEtudiant);
        rs.next();
        this.id = rs.getLong("id");
        this.numeroEtudiant = rs.getInt("numeroEtudiant");
        this.prenom = rs.getString("prenom");
        this.nom = rs.getString("nom");
        this.email = rs.getString("email");
        this.telephone = rs.getString("telephone");
        this.notificationsActives = rs.getBoolean("notificationsActives");
        this.idPromotion = rs.getInt("idPromotion");
        this.idSpecialite = rs.getInt("idSpecialite");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getIdPromotion() {
        return idPromotion;
    }

    public void setIdPromotion(int idPromotion) {
        this.idPromotion = idPromotion;
    }

    public int getIdSpecialite() {
        return idSpecialite;
    }

    public void setIdSpecialite(int idSpecialite) {
        this.idSpecialite = idSpecialite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isNotificationsActives() {
        return notificationsActives;
    }

    public void setNotificationsActives(boolean notificationsActives) {
        this.notificationsActives = notificationsActives;
    }

    public int getNumeroEtudiant() {
        return numeroEtudiant;
    }

    public void setNumeroEtudiant(int numeroEtudiant) {
        this.numeroEtudiant = numeroEtudiant;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Etudiant other = (Etudiant) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.numeroEtudiant != other.numeroEtudiant) {
            return false;
        }
        if ((this.prenom == null) ? (other.prenom != null) : !this.prenom.equals(other.prenom)) {
            return false;
        }
        if ((this.nom == null) ? (other.nom != null) : !this.nom.equals(other.nom)) {
            return false;
        }
        if ((this.email == null) ? (other.email != null) : !this.email.equals(other.email)) {
            return false;
        }
        if ((this.telephone == null) ? (other.telephone != null) : !this.telephone.equals(other.telephone)) {
            return false;
        }
        if (this.notificationsActives != other.notificationsActives) {
            return false;
        }
        if (this.idPromotion != other.idPromotion) {
            return false;
        }
        if (this.idSpecialite != other.idSpecialite) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 97 * hash + this.numeroEtudiant;
        hash = 97 * hash + (this.prenom != null ? this.prenom.hashCode() : 0);
        hash = 97 * hash + (this.nom != null ? this.nom.hashCode() : 0);
        hash = 97 * hash + (this.email != null ? this.email.hashCode() : 0);
        hash = 97 * hash + (this.telephone != null ? this.telephone.hashCode() : 0);
        hash = 97 * hash + (this.notificationsActives ? 1 : 0);
        hash = 97 * hash + this.idPromotion;
        hash = 97 * hash + this.idSpecialite;
        return hash;
    }
    
    
    
    @Override
    public String toString(){
        return ""+this.id+" "+this.numeroEtudiant+" "+this.prenom+" "+this.nom + " " + this.email +
                " "+this.telephone+" "+this.notificationsActives+" "+this.idPromotion+" "+this.idSpecialite;
    }
}