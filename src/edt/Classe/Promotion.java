/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edt.Classe;

import edt.mysql.BD_MySQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
/**
 *
 * @author Marie
 */
public class Promotion implements Model_JDBC {
    private int id;
    private String nom;
    private int annee;
    private Timestamp tsDebut;
    private Timestamp tsFin;
    
    public Promotion(String nom, int annee, Timestamp tsDebut, Timestamp tsFin){
        this.id = 0;
        this.nom = nom;
        this.annee = annee;
        this.tsDebut = tsDebut;
        this.tsFin = tsFin;
    }
    
    public Promotion(int id) throws SQLException{
        ResultSet rs = BD_MySQL.executer_requete("SELECT * FROM Promotion WHERE id="+id);
        rs.next();
        this.id = rs.getInt("id");
        this.nom = rs.getString("nom");
        this.annee = rs.getInt("annee");
        this.tsDebut = rs.getTimestamp("tsDebut");
        this.tsFin = rs.getTimestamp("tsFin");
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
     * @return the annee
     */
    public int getAnnee() {
        return annee;
    }

    /**
     * @param annee the annee to set
     */
    public void setAnnee(int annee) {
        this.annee = annee;
    }

    /**
     * @return the tsDebut
     */
    public Timestamp getTsDebut() {
        return tsDebut;
    }

    /**
     * @param tsDebut the tsDebut to set
     */
    public void setTsDebut(Timestamp tsDebut) {
        this.tsDebut = tsDebut;
    }

    /**
     * @return the tsFin
     */
    public Timestamp getTsFin() {
        return tsFin;
    }

    /**
     * @param tsFin the tsFin to set
     */
    public void setTsFin(Timestamp tsFin) {
        this.tsFin = tsFin;
    }

    @Override
    public void save() {
         String requete;   
        
        if(this.id == 0){
            requete = "INSERT INTO Promotion (nom, annee, tsDebut, tsFin) "
                    + "VALUES ('"+this.nom
                    +"', "+this.annee
                    +", '"+this.tsDebut
                    +"', '"+this.tsFin
                    +"');";
        }else{
            requete = "UPDATE Promotion SET "
                    + "nom='"+this.nom
                    +"', annee='"+this.annee
                    +"', tsDebut='"+this.tsDebut
                    +"', tsFin='"+this.tsFin
                    +"' WHERE id='"+this.id+"'";
        }
        
        this.id = BD_MySQL.executer_update(requete);
    }

    @Override
    public void delete() {
         String requete;  

        requete = "DELETE FROM Promotion "
                +" WHERE id='"+this.id+"';";
        
        this.id = BD_MySQL.executer_update(requete);
    }
    public static int nombre_Promotion() throws SQLException{
        int nb;
        String requete = "SELECT COUNT(id) AS nb FROM Promotion ;";
        ResultSet rs = BD_MySQL.executer_requete(requete);
        rs.next();
        nb = rs.getInt("nb");
        return nb;
    }
    public static ArrayList<Integer> liste_id_promotion() throws SQLException{
        ArrayList<Integer> liste_id_etudiants_promotion = new ArrayList();
        String requete = "SELECT id FROM Promotion ORDER BY nom, annee, tsDebut, tsFin;";
        ResultSet rs = BD_MySQL.executer_requete(requete);
        while(rs.next()){
            liste_id_etudiants_promotion.add(rs.getInt("id"));
        }
        return liste_id_etudiants_promotion;
    }
    public static ArrayList<String> liste_nom_promotion() throws SQLException{
        ArrayList<String> liste_promotion = new ArrayList();
        ArrayList<Integer> liste_id_promotion = liste_id_promotion();
        for (int l : liste_id_promotion) {
            if(l != 0){
            Promotion promo = new Promotion(l);
            liste_promotion.add(promo.getNom());
            }
        }
        return liste_promotion;
    }
    public static int id_Promotion(String nom) throws SQLException{
        String requete = "SELECT id FROM Promotion WHERE nom='"+nom+"';";
        ResultSet rs = BD_MySQL.executer_requete(requete);
        rs.next();
        return rs.getInt("id");
    }
    public static ArrayList<Promotion> liste_Promotion() throws SQLException{
        ArrayList<Promotion> liste_Promotion = new ArrayList();
        ArrayList<Integer> liste_id_Promotion = liste_id_promotion();
        for (int l : liste_id_Promotion) {
            if(l != 0)
            liste_Promotion.add(new Promotion(l));
        }
        return liste_Promotion;
    }
    
}
