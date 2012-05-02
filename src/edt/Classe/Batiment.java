/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edt.Classe;

import edt.mysql.BD_MySQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Marie
 */
public class Batiment implements Model_JDBC {
    private int id;
    private String nom;
    private double lat;
    private double lon;
    
    public Batiment (String nom, double lat, double lon){
        this.id = 0;
        this.nom = nom;
        this.lat = lat;
        this.lon = lon;
    }
    
    public Batiment(int id) throws SQLException{
        ResultSet rs = BD_MySQL.executer_requete("SELECT * FROM Batiment WHERE id="+id);
        rs.next();
        this.id = rs.getInt("id");
        this.nom = rs.getString("nom");
        this.lat = rs.getDouble("lat");
        this.lon = rs.getDouble("lon");
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
     * @return the lat
     */
    public double getLat() {
        return lat;
    }

    /**
     * @param lat the lat to set
     */
    public void setLat(double lat) {
        this.lat = lat;
    }

    /**
     * @return the lon
     */
    public double getLon() {
        return lon;
    }

    /**
     * @param lon the lon to set
     */
    public void setLon(double lon) {
        this.lon = lon;
    }

    @Override
    public void delete() {
        
    }

    @Override
    public void save() {
        String requete;
        
        if(this.id == 0){
            requete = "INSERT INTO Batiment (nom, lat, lon) "
                    + "VALUES ('"+this.nom
                    +"', '"+this.lat
                    +"', '"+this.lon+"')";
        }else{
            requete = "UPDATE Batiment SET "
                    + "nom='"+this.nom
                    +"', lat='"+this.lat
                    +"', lon='"+this.lon
                    +"' WHERE id='"+this.id+"'";
        }
        
        this.id = BD_MySQL.executer_update(requete);
    }
    
    public static ArrayList<Batiment> liste_Batiment() throws SQLException{
        ArrayList<Batiment> liste_Batiment = new ArrayList();
        ArrayList<Integer> liste_id_Batiment = liste_id_Batiment();
        for (int l : liste_id_Batiment) {
            liste_Batiment.add(new Batiment(l));
        }
        return liste_Batiment;
    }
    public static int id_Batiment(String nom) throws SQLException{
        String requete = "SELECT id FROM Batiment WHERE nom='"+nom+"';";
        ResultSet rs = BD_MySQL.executer_requete(requete);
        rs.next();
        return rs.getInt("id");
    }
    public static ArrayList<Integer> liste_id_Batiment() throws SQLException{
        ArrayList<Integer> liste_id_Batiment = new ArrayList();
        String requete = "SELECT id FROM Batiment ORDER BY nom, lat, lon;";
        ResultSet rs = BD_MySQL.executer_requete(requete);
        while(rs.next()){
            liste_id_Batiment.add(rs.getInt("id"));
        }
        return liste_id_Batiment;
    }
    public static String nomBatiment(int id) throws SQLException{
         String requete = "SELECT nom FROM Batiment WHERE id="+id+" ORDER BY  lat, lon;";
         ResultSet rs = BD_MySQL.executer_requete(requete);
         rs.next();
         return rs.getString("nom");
    }
    
    
}
