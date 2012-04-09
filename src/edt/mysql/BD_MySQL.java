package edt.mysql;

import edt.Classe.*;
import edt.sma_interface.APIMain;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BD_MySQL implements APIMain {

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
    public static int executer_update(String requete) {
        int key = 0;
        if (BD_MySQL.debug){
            System.out.println("DEBUG : REQUETE : "+requete);
        }
        try {
            BD_MySQL.stmt.executeUpdate(requete, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            Logger.getLogger(BD_MySQL.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        ResultSet rs;
        try {
            rs = BD_MySQL.stmt.getGeneratedKeys();
            if(rs.next()){
                key = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
  
        return key;
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
        return nb;
    }
    public static int nombre_Promotion() throws SQLException{
        int nb;
        String requete = "SELECT COUNT(id) AS nb FROM Promotion ;";
        ResultSet rs = BD_MySQL.executer_requete(requete);
        rs.next();
        nb = rs.getInt("nb");
        return nb;
    }
    public static ArrayList<Integer> liste_id_etudiants_promotion(int idPromotion) throws SQLException{
        BD_MySQL.init();
        ArrayList<Integer> liste_id_etudiants_promotion = new ArrayList();
        String requete = "SELECT id FROM Etudiant WHERE idPromotion="+idPromotion+" ORDER BY nom, prenom, email, telephone, notificationsActives, idPromotion ,idSpecialite;";
        ResultSet rs = executer_requete(requete);
        while(rs.next()){
            liste_id_etudiants_promotion.add(rs.getInt("id"));
        }
        return liste_id_etudiants_promotion;
    }
    public static ArrayList<Integer> liste_id_UE_promotion(int idPromotion) throws SQLException{
        BD_MySQL.init();
        ArrayList<Integer> liste_id_UE_promotion = new ArrayList();
        String requete = "SELECT id FROM UE WHERE idPromotion="+idPromotion+" ORDER BY nom, intitule, nbHeuresCours, nbHeuresTD, nbHeuresTP, ECTS;";
        ResultSet rs = executer_requete(requete);
        while(rs.next()){
            liste_id_UE_promotion.add(rs.getInt("id"));
        }
        return liste_id_UE_promotion;
    }
    public static ArrayList<Integer> liste_id_Salle_promotion() throws SQLException{
        BD_MySQL.init();
        ArrayList<Integer> liste_id_Salle_promotion = new ArrayList();
        String requete = "SELECT id FROM Salle ORDER BY nom, nomBatiment;";
        ResultSet rs = executer_requete(requete);
        while(rs.next()){
            liste_id_Salle_promotion.add(rs.getInt("id"));
        }
        return liste_id_Salle_promotion;
    }
    public static ArrayList<Integer> liste_id_Batiment() throws SQLException{
        BD_MySQL.init();
        ArrayList<Integer> liste_id_Batiment = new ArrayList();
        String requete = "SELECT id FROM Batiment ORDER BY nom, lat, lon;";
        ResultSet rs = executer_requete(requete);
        while(rs.next()){
            liste_id_Batiment.add(rs.getInt("id"));
        }
        return liste_id_Batiment;
    }
    public static ArrayList<Integer> liste_id_Intervenant() throws SQLException{
        BD_MySQL.init();
        ArrayList<Integer> liste_id_Intervenant = new ArrayList();
        String requete = "SELECT id FROM Intervenant ORDER BY nom, prenom, email;";
        ResultSet rs = executer_requete(requete);
        while(rs.next()){
            liste_id_Intervenant.add(rs.getInt("id"));
        }
        return liste_id_Intervenant;
    }
    public static ArrayList<Integer> liste_id_promotion() throws SQLException{
        BD_MySQL.init();
        ArrayList<Integer> liste_id_etudiants_promotion = new ArrayList();
        String requete = "SELECT id FROM Promotion ORDER BY nom, annee, tsDebut, tsFin;";
        ResultSet rs = executer_requete(requete);
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
    public static int id_etudiants_promotion(int numeroEtudiant, String nom, String prenom, int idPromotion) throws SQLException{
        BD_MySQL.init();
        String requete = "SELECT id FROM Etudiant WHERE  numeroEtudiant="+numeroEtudiant+" AND nom='"+nom+"' AND prenom='"+prenom+"' AND idPromotion="+idPromotion+";";
        ResultSet rs = executer_requete(requete);
        rs.next();
        return rs.getInt("id");
    }
    public static int id_UE_promotion(String nom, int idPromotion) throws SQLException{
        BD_MySQL.init();
        String requete = "SELECT id FROM UE WHERE nom='"+nom+"'AND idPromotion="+idPromotion+";";
        ResultSet rs = executer_requete(requete);
        rs.next();
        return rs.getInt("id");
    }
    public static ArrayList<UE> liste_UE_promotion(int idPromotion) throws SQLException{
        ArrayList<UE> liste_UE_promotion = new ArrayList();
        ArrayList<Integer> liste_id_UE_promotion = liste_id_UE_promotion(idPromotion);
        for (int l : liste_id_UE_promotion) {
            liste_UE_promotion.add(new UE(l));
        }
        return liste_UE_promotion;
    }
    public static int id_Salle(String nom, String nomBatiment, int Capacite) throws SQLException{
        BD_MySQL.init();
        String requete = "SELECT id FROM Salle WHERE nom='"+nom+"' AND nomBatiment='"+nomBatiment+"' AND capacite="+Capacite+";";
        ResultSet rs = executer_requete(requete);
        rs.next();
        return rs.getInt("id");
    }
    public static int id_Intervenant(String nom, String nomPrenom, String email) throws SQLException{
        BD_MySQL.init();
        String requete = "SELECT id FROM Intervenant WHERE nom='"+nom+"' AND prenom='"+nomPrenom+"' AND email='"+email+"';";
        ResultSet rs = executer_requete(requete);
        rs.next();
        return rs.getInt("id");
    }
    public static int id_Batiment(String nom) throws SQLException{
        BD_MySQL.init();
        String requete = "SELECT id FROM Batiment WHERE nom='"+nom+"';";
        ResultSet rs = executer_requete(requete);
        rs.next();
        return rs.getInt("id");
    }
    public static int id_Promotion(String nom) throws SQLException{
        BD_MySQL.init();
        String requete = "SELECT id FROM Promotion WHERE nom='"+nom+"';";
        ResultSet rs = executer_requete(requete);
        rs.next();
        return rs.getInt("id");
    }
    public static ArrayList<Salle> liste_Salle_promotion() throws SQLException{
        ArrayList<Salle> liste_Salle_promotion = new ArrayList();
        ArrayList<Integer> liste_id_Salle_promotion = liste_id_Salle_promotion();
        for (int l : liste_id_Salle_promotion) {
            liste_Salle_promotion.add(new Salle(l));
        }
        return liste_Salle_promotion;
    }
    public static ArrayList<Batiment> liste_Batiment() throws SQLException{
        ArrayList<Batiment> liste_Batiment = new ArrayList();
        ArrayList<Integer> liste_id_Batiment = liste_id_Batiment();
        for (int l : liste_id_Batiment) {
            liste_Batiment.add(new Batiment(l));
        }
        return liste_Batiment;
    }
    public static ArrayList<Intervenant> liste_Intervenant() throws SQLException{
        ArrayList<Intervenant> liste_intervenant = new ArrayList();
        ArrayList<Integer> liste_id_intervenant = liste_id_Intervenant();
        for (int l : liste_id_intervenant) {
            liste_intervenant.add(new Intervenant(l));
        }
        return liste_intervenant;
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
    public static ArrayList<Etudiant> liste_etudiants_promotion(int idPromotion) throws SQLException{
        ArrayList<Etudiant> liste_etudiants_promotion = new ArrayList();
        ArrayList<Integer> liste_id_etudiants_promotion = liste_id_etudiants_promotion(idPromotion);
        for (int l : liste_id_etudiants_promotion) {
            liste_etudiants_promotion.add(new Etudiant(l));
        }
        return liste_etudiants_promotion;
    }

    @Override
    public ArrayList<Integer> getListIdEtudiantBDD() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Integer> getListeIdEnseignantBDD() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Integer> getListeIdEDTBDD() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Integer> getListIdUEBDD() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
