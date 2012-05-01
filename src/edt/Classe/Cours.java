/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edt.Classe;

import edt.mysql.BD_MySQL;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Marie
 */
public class Cours implements Model_JDBC {
    private int id;
    private Timestamp tsDebut;
    private Timestamp tsFin;
    private int idUE;
    private int idSalle;
    private int idIntervenant;
    private int idTypeCours;
    
    public Cours(Timestamp tsDebut, Timestamp tsFin, int idUE, int idSalle, int idIntervenant, int idTypeCours){
        this.id = 0;
        this.tsDebut = tsDebut;
        this.tsFin = tsFin;
        this.idUE = idUE;
        this.idSalle = idSalle;
        this.idIntervenant = idIntervenant;
        this.idTypeCours = idTypeCours;
    }
    
    public Cours(int id) throws SQLException{
        ResultSet rs = BD_MySQL.executer_requete("SELECT * FROM Cours WHERE id="+id);
        rs.next();
        this.id = rs.getInt("id");
        this.tsDebut = rs.getTimestamp("tsDebut");
        this.tsFin = rs.getTimestamp("tsFin");
        this.idUE = rs.getInt("idUE");
        this.idSalle = rs.getInt("idSalle");
        this.idIntervenant = rs.getInt("idIntervenant");
        this.idTypeCours = rs.getInt("idTypeCours");
    }

  /**
     * @return the id
     */
    public int getId() {
        return id;
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

    /**
     * @return the idUE
     */
    public int getIdUE() {
        return idUE;
    }
    public String getNomUE(){
        return UE.nomUE(this.idUE);
    }
    /**
     * @param idUE the idUE to set
     */
    public void setIdUE(int idUE) {
        this.idUE = idUE;
    }

    /**
     * @return the idSalle
     */
    public int getIdSalle() {
        return idSalle;
    }

    /**
     * @param idSalle the idSalle to set
     */
    public void setIdSalle(int idSalle) {
        this.idSalle = idSalle;
    }

    /**
     * @return the idIntervenant
     */
    public int getIdIntervenant() {
        return idIntervenant;
    }

    /**
     * @param idIntervenant the idIntervenant to set
     */
    public void setIdIntervenant(int idIntervenant) {
        this.idIntervenant = idIntervenant;
    }

    /**
     * @return the idTypeCours
     */
    public int getIdTypeCours() {
        return idTypeCours;
    }
    public String getNomTypeCours(){
        return Type_cours.nomType_cours(this.idTypeCours);
    }
    /**
     * @param idTypeCours the idTypeCours to set
     */
    public void setIdTypeCours(int idTypeCours) {
        this.idTypeCours = idTypeCours;
    }
    
     @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cours other = (Cours) obj;
        if (this.getId() != other.getId()) {
            return false;
        }
        if (this.getIdUE() != other.getIdUE()) {
            return false;
        }
        if (this.getIdSalle() != other.getIdSalle()) {
            return false;
        }
        if (this.getIdIntervenant() != other.getIdIntervenant()) {
            return false;
        }
        if (this.getIdTypeCours() != other.getIdTypeCours()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (int) (this.getId() ^ (this.getId() >>> 32));
        hash = 97 * hash + this.getIdUE();
        hash = 97 * hash + this.idSalle;
        hash = 97 * hash + this.getIdIntervenant();
        hash = 97 * hash + this.getIdTypeCours();
        return hash;
    }

    @Override
    public void save() {
        String requete;
        
        if(this.getId() == 0){
            requete = "INSERT INTO Cours (tsDebut, tsFin, idUE, idSalle, idIntervenant, idTypeCours) "
                    + "VALUES ('"+this.getTsDebut()
                    +"', '"+this.tsFin
                    +"', '"+this.idUE
                    +"', '"+this.idSalle
                    +"', '"+this.idIntervenant
                    +"', '"+this.idTypeCours
                    +"')";
        }else{
            requete = "UPDATE Cours SET "
                    + "tsDebut='"+this.tsDebut
                    +"', tsFin='"+this.tsFin
                    +"', idUE='"+this.idUE
                    +"', idSalle='"+this.idSalle
                    +"', idIntervenant='"+this.idIntervenant
                    +"', idTypeCours='"+this.idTypeCours
                    +"' WHERE id='"+this.getId()+"'";
        }
        
        this.id = BD_MySQL.executer_update(requete);
    }

    @Override
    public void delete() {
         String requete;                                      
        BD_MySQL.init();

        requete = "DELETE FROM Cours "
                +" WHERE id='"+this.id+"';";
        
        this.id = BD_MySQL.executer_update(requete);
    }
    
    public static ArrayList<Integer> liste_id_cours_promotion(int idPromotion) throws SQLException{
        BD_MySQL.init();
        ArrayList<Integer> liste_id_cours_promotion = new ArrayList();
        String requete = "SELECT id FROM Cours ORDER BY idUE, idSalle, idIntervenant, idTypeCours, tsDebut, tsFin;";
        ResultSet rs = BD_MySQL.executer_requete(requete);
        while(rs.next()){
            liste_id_cours_promotion.add(rs.getInt("id"));
        }
        return liste_id_cours_promotion;
    }
    
    public static ArrayList<Cours> liste_Cours_promotion(int idPromotion) throws SQLException{
        ArrayList<Cours> liste_Cours_promotion = new ArrayList();
        ArrayList<Integer> liste_id_cours_promotion = liste_id_cours_promotion(idPromotion);
        for (int l : liste_id_cours_promotion) {
            liste_Cours_promotion.add(new Cours(l));
        }
        return liste_Cours_promotion;
    }
    
    public int nombre_de_quart_heure() {
        int ecarth = this.tsFin.getHours() - this.tsDebut.getHours();
        int ecartm = this.tsFin.getMinutes() - this.tsDebut.getMinutes();
        
        return ecarth*4 + ecartm/15;
    }
}
