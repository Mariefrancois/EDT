package edt.Classe;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BD_MySQL {

    /*
     * Il faudra mettre les informations de base de donnée 
     *  dans un fichier de configuration
     * Il faudra donc créer une classe pour lire dans un fichier
     */

    static String serveur_BD = "127.0.0.1";
    static String nom_BD = "UPS_EDT";
    static String utilisateur_BD = "marie";
    static String motDePasse_BD = "jeremythebest";

    static String classForName = "com.mysql.jdbc.Driver";
    static String connectionUrl = 
            "jdbc:mysql://" + BD_MySQL.serveur_BD + "/"
            + BD_MySQL.nom_BD + "?user=" + BD_MySQL.utilisateur_BD
            + "&password=" + BD_MySQL.motDePasse_BD;

    static Connection con;
    static Statement stmt;
    
    static Boolean debug = true;

    /**
     * Etablis la connexion à la base de données
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static void init(){
        try {
            Class.forName(BD_MySQL.classForName);
            BD_MySQL.con = DriverManager.getConnection(BD_MySQL.connectionUrl);
            BD_MySQL.stmt = BD_MySQL.con.createStatement();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BD_MySQL.class.getName())
                    .log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BD_MySQL.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Ferme la connexion à la base de données
     */
    public static void close(){
        try {
            BD_MySQL.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(BD_MySQL.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Renvois le ResultSet correspond à la requete en paramètre
     * @param requete Correspond à la requete SQL
     * @return ResultSet du resultat de la requete
     */
    public static ResultSet executer_requete(String requete){
        if (BD_MySQL.debug){
            System.out.println("DEBUG : REQUETE : "+requete);
        }
        ResultSet rs = null;
        try {
            rs = BD_MySQL.stmt.executeQuery(requete);
        } catch (SQLException ex) {
            Logger.getLogger(BD_MySQL.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        if (BD_MySQL.debug){
            print_resultSet(rs);
        }
        return rs;
    }
    
    /**
     * Renvois le ResultSet correspond à la requete en paramètre
     * @param requete Correspond à la requete SQL
     * @return ResultSet du resultat de la requete
     */
    public static void executer_update(String requete){
        if (BD_MySQL.debug){
            System.out.println("DEBUG : REQUETE : "+requete);
        }
        try {
            BD_MySQL.stmt.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(BD_MySQL.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Affiche le resultSet en System.out (utile pour le DEBUG)
     * @param rs ResultSet à afficher
     */
    public static void print_resultSet(ResultSet rs){
        if (rs != null){
            ResultSetMetaData md = null;
            int nombreColumns = 0;
            try {
                md = rs.getMetaData();
                nombreColumns = md.getColumnCount();
                String[] nomColumns = new String[nombreColumns];
                for(int i = 1 ; i < (nombreColumns+1) ; i++){
                    nomColumns[i-1] = md.getColumnName(i);
                }
                int i = 1;
                while(rs.next()){
                    System.out.print("DEBUG : Row "+i+" : ");
                    for(String s : nomColumns){
                        System.out.print(rs.getString(s)+" ");
                    }
                    i++;
                    System.out.println();
                }
                rs.beforeFirst();
            } catch (SQLException ex) {
                Logger.getLogger(BD_MySQL.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static int taille_resultSet(ResultSet rs) throws SQLException{
        int taille = 0;
        while(rs.next()){
            taille++;
        }
        rs.beforeFirst();
        return taille;
    }
    
    public static int nombre_etudiants(int idPromotion) throws SQLException{
        int nb;
        String requete = "SELECT COUNT(id) AS nb FROM Etudiant WHERE idPromotion="+idPromotion+";";
        ResultSet rs = BD_MySQL.executer_requete(requete);
        rs.next();
        nb = rs.getInt("nb");
        rs.close();
        return nb;
    }
}
