/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edt.Classe;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Marie
 */
public class Etudiant  {
    
    private long id;
    private int numeroEtudiant;
    private String prenom;
    private String nom;
    private String email;
    private String telephone;
    private boolean notificationsActives;
    private int idPromotion;
    private int idSpecialite;
    
    public Etudiant(long idEtudiant) throws SQLException{
        ResultSet rs = BD_MySQL.executer_requete("SELECT * FROM Etudiant WHERE id="+idEtudiant);
        
        int taille = BD_MySQL.taille_resultSet(rs);
        switch(taille){
            case 0:
                // Etudiant inexistant;
                break;
            case 1:
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
                break;
            default:
                // Plusieurs etudiant avec la meme ID;
                break;
        }    
    }
    
    public Etudiant(int numeroEtudiant, String nom, String prenom, String email, String telephone, int idPromotion, int idSpecialite) throws SQLException {
        String requete = "SELECT * FROM Etudiant WHERE "
                + "numeroEtudiant="+numeroEtudiant+" AND "
                + "prenom='"+prenom+"';";
        ResultSet rs = BD_MySQL.executer_requete(requete);
        int taille = BD_MySQL.taille_resultSet(rs);
        switch(taille){
            case 0:
                // Etudiant inexistant;
                break;
            case 1:
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
                rs.close();
                break;
            default:
                // Plusieurs etudiant avec la meme ID;
                break;
        }   
    }
    
    public static long ajouter_etudiant(int numeroEtudiant, String nom, String prenom, String email,String telephone, int idPromotion,int idSpecialite) throws SQLException{
        String requete = ""
                + "INSERT INTO `Etudiant` (`numeroEtudiant`, `nom`, `prenom`, `email`, `telephone`, `notificationsActives`, `idPromotion`, `idSpecialite`) VALUES "
                + "(" + numeroEtudiant + ", '"
                + nom + "','" + prenom + "', '"
                + email + "','" + telephone
                + "', 1, " + idPromotion + ", " + idSpecialite + ");";
        BD_MySQL.executer_update(requete);
        //creer un utilisateur
        return new Etudiant(numeroEtudiant, nom, prenom, email, telephone, idPromotion, idSpecialite).getId();
    }
    public static void supprimer_etudiant(long id){
            String requete = "DELETE FROM Etudiant WHERE id = " +id+ ";";
            //supprimer un utilisateur
            BD_MySQL.executer_update(requete);
            
    } 
    
    public static void modifier_etudiant(int idEtudiant, int numeroEtudiant, String nom, String prenom, String email,String telephone, int idPromotion,int idSpecialite){
        String requete = "UPDATE Etudiant SET numeroEtudiant= "+ numeroEtudiant 
                + ", nom= '"+ nom + "', prenom='" + prenom 
                + "', email='"+ email + "', telephone='" + telephone
                + "', notificationsActives=1, idPromotion=" + idPromotion 
                + ", idSpecialite=" + idSpecialite + " WHERE id="+idEtudiant;
        BD_MySQL.executer_update(requete);
    }
    
    public static ArrayList<Long> liste_id_etudiants_promotion(int idPromotion) throws SQLException{
        ArrayList<Long> liste_id_etudiants_promotion = new ArrayList();
        String requete = "SELECT id FROM Etudiant WHERE idPromotion="+idPromotion+" ORDER BY nom, prenom;";
        ResultSet rs = BD_MySQL.executer_requete(requete);
        while(rs.next()){
            liste_id_etudiants_promotion.add(rs.getLong("id"));
        }
        return liste_id_etudiants_promotion;
    }
    
    public static ArrayList<Etudiant> liste_etudiants_promotion(int idPromotion) throws SQLException{
        ArrayList<Etudiant> liste_etudiants_promotion = new ArrayList();
        ArrayList<Long> liste_id_etudiants_promotion = Etudiant.liste_id_etudiants_promotion(idPromotion);
        for (long l : liste_id_etudiants_promotion) {
            liste_etudiants_promotion.add(new Etudiant(l));
        }
        return liste_etudiants_promotion;
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