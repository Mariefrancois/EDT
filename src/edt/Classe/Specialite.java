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
public class Specialite implements Model_JDBC {
    private int id;
    private String nom;
    private String intitule;
    private int idPromotion;
    
    public Specialite(String nom, String intitule, int idPromotion){
        this.id = 0;
        this.nom = nom;
        this.intitule = intitule;
        this.idPromotion = idPromotion;
    }
    
    public Specialite(int id) throws SQLException{
        ResultSet rs = BD_MySQL.executer_requete("SELECT * FROM Specialite WHERE id="+id);
        rs.next();
        this.id = rs.getInt("id");
        this.nom = rs.getString("nom");
        this.intitule = rs.getString("intitule");
        this.idPromotion = rs.getInt("idPromotion");
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

    /**
     * @return the intitule
     */
    public String getIntitule() {
        return intitule;
    }

    /**
     * @param intitule the intitule to set
     */
    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    @Override
    public void save() {
        String requete;
        
        if(this.id == 0){
            requete = "INSERT INTO Specialite (nom, intitule, idPromotion) "
                    + "VALUES ('"+this.nom
                    +"', '"+this.intitule
                    +"', '"+this.idPromotion
                    +"')";
        }else{
            requete = "UPDATE Specialite SET "
                    + "nom='"+this.nom
                    +"', intitule='"+this.intitule
                    +"', idPromotion='"+this.idPromotion
                    +"' WHERE id='"+this.id+"'";
        }
        
        this.id = BD_MySQL.executer_update(requete);
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public static int id_Specialite_promotion(String nom, int idPromotion){
            int id = 0;
        try {
            String requete = "SELECT id FROM Specialite WHERE nom='"+nom+"'AND idPromotion="+idPromotion+";";
            ResultSet rs = BD_MySQL.executer_requete(requete);
            rs.next();
            id = rs.getInt("id");
        } catch (SQLException ex) {
            Logger.getLogger(Specialite.class.getName()).log(Level.SEVERE, null, ex);
        }
            return id;
    }
    public static ArrayList<Specialite> liste_Specialite_promotion(int idPromotion) throws SQLException{
        ArrayList<Specialite> liste_Specialite_promotion = new ArrayList();
        ArrayList<Integer> liste_id_Specialite_promotion = liste_id_Specialite_promotion(idPromotion);
        for (int l : liste_id_Specialite_promotion) {
            liste_Specialite_promotion.add(new Specialite(l));
        }
        return liste_Specialite_promotion;
    }
    public static ArrayList<Integer> liste_id_Specialite_promotion(int idPromotion) throws SQLException{
        ArrayList<Integer> liste_id_Specialite_promotion = new ArrayList();
        String requete = "SELECT id FROM Specialite WHERE idPromotion="+idPromotion+" ORDER BY nom, intitule;";
        ResultSet rs = BD_MySQL.executer_requete(requete);
        while(rs.next()){
            liste_id_Specialite_promotion.add(rs.getInt("id"));
        }
        return liste_id_Specialite_promotion;
    }
    public static String nomSpecialite(int id){
            String nom = "";
        try {
            String requete = "SELECT nom FROM Specialite WHERE id="+id+" ORDER BY  intitule;";
            ResultSet rs = BD_MySQL.executer_requete(requete);
            rs.next();
            nom = rs.getString("nom");
        } catch (SQLException ex) {
            Logger.getLogger(Specialite.class.getName()).log(Level.SEVERE, null, ex);
        }
            return nom;
    }
     public static ArrayList<String> list_nom_Specialite(int idPromotion) {
        ArrayList<Specialite> list_Specialite = null;
        try {
            list_Specialite = liste_Specialite_promotion(idPromotion);
        } catch (SQLException ex) {
            Logger.getLogger(Specialite.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<String> list_nom_Specialite = new ArrayList();
        for (Specialite l : list_Specialite) {
                list_nom_Specialite.add(l.getNom());
            }
        return list_nom_Specialite;
    }

    /**
     * @return the idPromotion
     */
    public int getIdPromotion() {
        return idPromotion;
    }

    /**
     * @param idPromotion the idPromotion to set
     */
    public void setIdPromotion(int idPromotion) {
        this.idPromotion = idPromotion;
    }
}
