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
public class Seance implements Model_JDBC {
    
    private int id;
    private String nom;
    private int duree;
    private int idType_Cours;
    private int idSalle;
    private int idIntervenant;
    private int idUE;
    private int effectue;
    private int idSeancePrecedente;
    
    public Seance (String nom, int duree, int idType_Cours, int idSalle, int idIntervenant, int idUE, int idSeancePrecedente){
        this.id = 0;
        this.nom = nom;
        this.duree = duree;
        this.idType_Cours = idType_Cours;
        this.idSalle = idSalle;
        this.idIntervenant = idIntervenant;
        this.idUE = idUE;
        this.effectue = 0;
        this.idSeancePrecedente = idSeancePrecedente;
    }
    
    public Seance(int id) throws SQLException{
        ResultSet rs = BD_MySQL.executer_requete("SELECT * FROM Seance WHERE id="+id);
        rs.next();
        this.id = rs.getInt("id");
        this.nom = rs.getString("nom");
        this.duree = rs.getInt("duree");
        this.idType_Cours = rs.getInt("idTypeCours");
        this.idSalle = rs.getInt("idSalle");
        this.idIntervenant = rs.getInt("idIntervenant");
        this.idUE = rs.getInt("idUE");
        this.effectue = rs.getInt("effectue");
        this.idSeancePrecedente = rs.getInt("idSeancePrecedente");
    }
    @Override
    public void save() {
         String requete;                                      
        BD_MySQL.init();
        
        if(this.id == 0){
            requete = "INSERT INTO Seance (nom, duree, effectue, idUE, idSalle, idIntervenant, idTypeCours, idSeancePrecedente) "
                    + "VALUES ('"+this.nom
                    + "', '"+this.duree
                    + "', '"+this.effectue
                    + "', '"+this.idUE
                    + "', '"+this.idSalle
                    + "', '"+this.idIntervenant
                    + "', '"+this.idType_Cours
                    + "', '"+this.idSeancePrecedente
                    +"');";
        }else{
            requete = "UPDATE Seance SET "
                    + "nom='"+this.nom
                    + "', duree='"+this.duree
                    + "', effectue='"+this.effectue
                    + "', idUE='"+this.idUE
                    + "', idSalle='"+this.idSalle
                    + "', idIntervenant='"+this.idIntervenant
                    + "', idTypeCours='"+this.idType_Cours
                    + "', idSeancePrecedente='"+this.idSeancePrecedente
                    +"' WHERE id='"+this.id+"'";
        }
        
        this.id = BD_MySQL.executer_update(requete);
    }

    @Override
    public void delete() {
         String requete;                                      
        BD_MySQL.init();

        requete = "DELETE FROM Seance "
                +" WHERE id='"+this.id+"';";
        
        this.id = BD_MySQL.executer_update(requete);
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
     * @return the duree
     */
    public int getDuree() {
        return duree;
    }

    /**
     * @param duree the duree to set
     */
    public void setDuree(int duree) {
        this.duree = duree;
    }

    /**
     * @return the idType_Cours
     */
    public int getIdType_Cours() {
        return idType_Cours;
    }

    /**
     * @param idType_Cours the idType_Cours to set
     */
    public void setIdType_Cours(int idType_Cours) {
        this.idType_Cours = idType_Cours;
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
     * @return the idUE
     */
    public int getIdUE() {
        return idUE;
    }

    /**
     * @param idUE the idUE to set
     */
    public void setIdUE(int idUE) {
        this.idUE = idUE;
    }
    
    public static int id_Creneau(String nom){
            BD_MySQL.init();
            int id = 0;
        try {
            String requete = "SELECT id FROM Seance WHERE nom='"+nom+"';";
            ResultSet rs = BD_MySQL.executer_requete(requete);
            rs.next();
            id = rs.getInt("id");
        } catch (SQLException ex) {
            Logger.getLogger(Seance.class.getName()).log(Level.SEVERE, null, ex);
        }
            return id;
    }
    
    public static ArrayList<Seance> liste_Seance() throws SQLException{
        ArrayList<Seance> liste_Seance = new ArrayList();
        ArrayList<Integer> liste_id_Seance = liste_id_Seance();
        for (int l : liste_id_Seance) {
            liste_Seance.add(new Seance(l));
        }
        return liste_Seance;
    }
    public static ArrayList<Seance> liste_Seance_UE(int idUE) throws SQLException{
        ArrayList<Seance> liste_Seance = new ArrayList();
        ArrayList<Integer> liste_id_Seance = liste_id_Seance_UE(idUE);
        for (int l : liste_id_Seance) {
            liste_Seance.add(new Seance(l));
        }
        return liste_Seance;
    }
    public static ArrayList<Integer> liste_id_Seance() throws SQLException{
        BD_MySQL.init();
        ArrayList<Integer> liste_id_Batiment = new ArrayList();
        String requete = "SELECT id FROM Seance ORDER BY nom, duree, effectue, idUE, idSalle, idIntervenant, idTypeCours, idSeancePrecedente;";
        ResultSet rs = BD_MySQL.executer_requete(requete);
        while(rs.next()){
            liste_id_Batiment.add(rs.getInt("id"));
        }
        return liste_id_Batiment;
    }

    public static ArrayList<Integer> liste_id_Seance_UE(int idUE) throws SQLException{
        BD_MySQL.init();
        ArrayList<Integer> liste_id_Batiment = new ArrayList();
        String requete = "SELECT id FROM Seance  WHERE idUE="+idUE+" ORDER BY nom, duree, effectue, idUE, idSalle, idIntervenant, idTypeCours, idSeancePrecedente;";
        ResultSet rs = BD_MySQL.executer_requete(requete);
        while(rs.next()){
            liste_id_Batiment.add(rs.getInt("id"));
        }
        return liste_id_Batiment;
    }
    
    public static ArrayList<String> liste_nom_Seance_UE(int idUE) {
        ArrayList<Seance> list_Seance = null;
        try {
            list_Seance = liste_Seance_UE(idUE);
        } catch (SQLException ex) {
            Logger.getLogger(UE.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<String> list_nom_Seance = new ArrayList();
        for (Seance l : list_Seance) {
                list_nom_Seance.add(l.getNom());
            }
        return list_nom_Seance;
    }
    public static String nomSeance(int id) throws SQLException{
         BD_MySQL.init();
         String requete = "SELECT nom FROM Seance WHERE id="+id+" ORDER BY  duree, effectue, idUE, idSalle, idIntervenant, idTypeCours, idSeancePrecedente;";
         ResultSet rs = BD_MySQL.executer_requete(requete);
         rs.next();
         return rs.getString("nom");
    }
    /**
     * @return the effectue
     */
    public int getEffectue() {
        return effectue;
    }

    /**
     * @param effectue the effectue to set
     */
    public void setEffectue(int effectue) {
        this.effectue = effectue;
    }

    /**
     * @return the idSeancePrecedente
     */
    public int getIdSeancePrecedente() {
        return idSeancePrecedente;
    }

    /**
     * @param idSeancePrecedente the idSeancePrecedente to set
     */
    public void setIdSeancePrecedente(int idSeancePrecedente) {
        this.idSeancePrecedente = idSeancePrecedente;
    }
}
