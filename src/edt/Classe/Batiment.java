/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edt.Classe;

import edt.mysql.BD_MySQL;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Marie
 */
public class Batiment implements Model_JDBC {
    private long id;
    private String nom;
    private double lat;
    private double lon;
    
    public Batiment (String nom, double lat, double lon){
        this.id = 0;
        this.nom = nom;
        this.lat = lat;
        this.lon = lon;
    }
    
    public Batiment(long id) throws SQLException{
        ResultSet rs = BD_MySQL.executer_requete("SELECT * FROM Batiment WHERE id="+id);
        rs.next();
        this.id = rs.getInt("id");
        this.nom = rs.getString("nom");
        this.lat = rs.getDouble("lat");
        this.lon = rs.getDouble("lon");
    }
    
    public long getId() {
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
    
    
    
}
