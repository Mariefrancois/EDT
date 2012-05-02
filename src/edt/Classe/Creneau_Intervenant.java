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
public class Creneau_Intervenant implements Model_JDBC  {
    private int id;
    private int idIntervenant;
    private Timestamp tsDebut;
    private Timestamp tsFin;

    public Creneau_Intervenant(int idIntervenant, Timestamp tsDebut, Timestamp tsFin){
        this.id = 0;
        this.idIntervenant = idIntervenant;
        this.tsDebut = tsDebut;
        this.tsFin = tsFin;
    }
    
    public Creneau_Intervenant(int id) throws SQLException{
        ResultSet rs = BD_MySQL.executer_requete("SELECT * FROM Creneau_Intervenant WHERE id="+id);
        rs.next();
        this.id = rs.getInt("id");
        this.idIntervenant = rs.getInt("idIntervenant");
        this.tsDebut = rs.getTimestamp("tsDebut");
        this.tsFin = rs.getTimestamp("tsFin");
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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
            requete = "INSERT INTO Creneau_Intervenant (idIntervenant, tsDebut, tsFin) "
                    + "VALUES ("+this.idIntervenant
                    +", '"+this.tsDebut
                    +"', '"+this.tsFin
                    +"');";
        }else{
            requete = "UPDATE Creneau_Intervenant SET "
                    + "idIntervenant="+this.idIntervenant
                    +", tsDebut='"+this.tsDebut
                    +"', tsFin='"+this.tsFin
                    +"' WHERE id='"+this.id+"'";
        }
        
        this.id = BD_MySQL.executer_update(requete);
    }

    @Override
    public void delete() {
         String requete;  

        requete = "DELETE FROM Creneau_Intervenant "
                +" WHERE id='"+this.id+"';";
        
        this.id = BD_MySQL.executer_update(requete);
    }
    public static ArrayList<Integer> liste_id_Creneau_Intervenant(int idIntervenant) throws SQLException{
        ArrayList<Integer> liste_id_Creneau_Intervenant = new ArrayList();
        String requete = "SELECT id FROM Creneau_Intervenant WHERE idIntervenant="+idIntervenant+" ORDER BY tsDebut, tsFin ;";
        ResultSet rs = BD_MySQL.executer_requete(requete);
        while(rs.next()){
            liste_id_Creneau_Intervenant.add(rs.getInt("id"));
        }
        return liste_id_Creneau_Intervenant;
    }
    
    public static ArrayList<Creneau_Intervenant> liste_Creneau_Intervenant(int idIntervenant) throws SQLException{
        ArrayList<Creneau_Intervenant> liste_Creneau_Intervenant = new ArrayList();
        ArrayList<Integer> liste_id_Creneau_Intervenant = liste_id_Creneau_Intervenant(idIntervenant);
        for (int l : liste_id_Creneau_Intervenant) {
            liste_Creneau_Intervenant.add(new Creneau_Intervenant(l));
        }
        return liste_Creneau_Intervenant;
    }
}
