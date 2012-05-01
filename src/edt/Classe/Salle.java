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
public class Salle implements Model_JDBC {
    private int id;
    private String nom;
    private int capacite;
    private String batiment;
    
    
    public Salle(String nom, int capacite,String batiment){
        this.id = 0;
        this.nom = nom;
        this.capacite = capacite;
        this.batiment = batiment;
    }
    
    public Salle(int id) throws SQLException{
        ResultSet rs = BD_MySQL.executer_requete("SELECT * FROM Salle WHERE id="+id);
        rs.next();
        this.id = rs.getInt("id");
        this.nom = rs.getString("nom");
        this.capacite = rs.getInt("capacite");
        this.batiment = rs.getString("nomBatiment");
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

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }
    
     /**
     * @return the idBatiment
     */
    public String getBatiment() {
        return batiment;
    }

    /**
     * @param idBatiment the idBatiment to set
     */
    public void setBatiment(String batiment) {
        this.batiment = batiment;
    }
    
     @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Salle other = (Salle) obj;
        if (this.id != other.id) {
            return false;
        }
        if ((this.nom == null) ? (other.nom != null) : !this.nom.equals(other.nom)) {
            return false;
        }
        if (this.capacite != other.capacite) {
            return false;
        }
        if (this.getBatiment() != other.getBatiment()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 97 * hash + (this.nom != null ? this.nom.hashCode() : 0);
        hash = 97 * hash + this.capacite;
        hash = 97 * hash + (this.batiment != null ? this.batiment.hashCode() : 0);
        return hash;
    }

    @Override
    public void save() {
        String requete;
        
        if(this.id == 0){
            requete = "INSERT INTO Salle (nom, capacite, nomBatiment) "
                    + "VALUES ('"+this.nom
                    +"', '"+this.capacite
                    +"', '"+this.batiment
                    +"')";
        }else{
            requete = "UPDATE Salle SET "
                    + "nom='"+this.nom
                    +"', capacite='"+this.capacite
                    +"', nomBatiment='"+this.batiment
                    +"' WHERE id='"+this.id+"'";
        }
        
        this.id = BD_MySQL.executer_update(requete);
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public static ArrayList<Salle> liste_Salle() throws SQLException{
        ArrayList<Salle> liste_Salle_promotion = new ArrayList();
        ArrayList<Integer> liste_id_Salle_promotion = liste_id_Salle_promotion();
        for (int l : liste_id_Salle_promotion) {
            liste_Salle_promotion.add(new Salle(l));
        }
        return liste_Salle_promotion;
    }
    public static int id_Salle(String nom, String nomBatiment, int Capacite) throws SQLException{
        BD_MySQL.init();
        String requete = "SELECT id FROM Salle WHERE nom='"+nom+"' AND nomBatiment='"+nomBatiment+"' AND capacite="+Capacite+";";
        ResultSet rs = BD_MySQL.executer_requete(requete);
        rs.next();
        return rs.getInt("id");
    }
    public static int id_Salle(String nom, String nomBatiment){
        BD_MySQL.init();
        int id = 0;
        String requete = "SELECT id FROM Salle WHERE nom='"+nom+"' AND nomBatiment='"+nomBatiment+"';";
        ResultSet rs = BD_MySQL.executer_requete(requete);
        try {
            rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(Salle.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            id = rs.getInt("id");
        } catch (SQLException ex) {
            Logger.getLogger(Salle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    public static ArrayList<Integer> liste_id_Salle_promotion() throws SQLException{
        BD_MySQL.init();
        ArrayList<Integer> liste_id_Salle_promotion = new ArrayList();
        String requete = "SELECT id FROM Salle ORDER BY nom, nomBatiment;";
        ResultSet rs = BD_MySQL.executer_requete(requete);
        while(rs.next()){
            liste_id_Salle_promotion.add(rs.getInt("id"));
        }
        return liste_id_Salle_promotion;
    }
    
     public static ArrayList<String> list_nom_Salle() {
        ArrayList<Salle> list_Salle = null;
        try {
            list_Salle = liste_Salle();
        } catch (SQLException ex) {
            Logger.getLogger(UE.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<String> list_nom_Salle = new ArrayList();
        for (Salle l : list_Salle) {
                list_nom_Salle.add(l.getBatiment()+" "+l.getNom());
            }
        return list_nom_Salle;
    }
}
