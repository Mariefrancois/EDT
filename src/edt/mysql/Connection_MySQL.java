/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edt.mysql;

import edt.sma_interface.APICours;
import edt.sma_interface.APIEdT;
import edt.sma_interface.APIEnseignant;
import edt.sma_interface.APIEtudiant;
import edt.sma_interface.APIMain;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author v-tech_master
 */
public class Connection_MySQL {
    
    private String serveur_BD = "127.0.0.1";
    private String nom_BD = "UPS_EDT";
    private String classForName = "com.mysql.jdbc.Driver";
    
    private Connection con;

    public static APIEtudiant etudiant;
    public static APICours cours;
    public static APIEnseignant enseignant;
    public static APIEdT edt;
    public static APIMain main;

    public Connection_MySQL (int num_BD, String utilisateur_BD, String motDePasse_BD) {
        String connectionUrl = 
            "jdbc:mysql://" + this.serveur_BD + "/"
            + this.nom_BD + num_BD + "?user=" + utilisateur_BD
            + "&password=" + motDePasse_BD;
        
        try {
            Class.forName(this.classForName);
            this.con = DriverManager.getConnection(connectionUrl);
            Statement stmt = con.createStatement();
            Request_MySQL request = new Request_MySQL(stmt);
            this.etudiant = new Etudiant_MySQL(request);
            this.cours = new Cours_MySQL(request);
            this.enseignant = new Enseignant_MySQL(request);
            this.edt = new Edt_MySQL(request);
            this.main = new Main_MySQL(request);
        } catch (SQLException ex) {
            Logger.getLogger(Connection_MySQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connection_MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Ferme la connexion à la base de données
     */
    public void close(){
        try {
            this.con.close();
            this.finalize();
        } catch (SQLException ex) {
            Logger.getLogger(Connection_MySQL.class.getName())
                    .log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(Connection_MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
