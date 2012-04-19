/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edt.mysql;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author v-tech_master
 */
class Request_MySQL {
    
    private Statement stmt;
    private final boolean debug = true;

    Request_MySQL(Statement stmt) {
        this.stmt = stmt;
    }
    
    /**
     * Renvois le ResultSet correspond à la requete en paramètre
     * @param requete Correspond à la requete SQL
     * @return ResultSet du resultat de la requete
     */
    public ResultSet executer_requete(String requete){
        if (this.debug){
            System.out.println("DEBUG : REQUETE : "+requete);
        }
        ResultSet rs = null;
        try {
            rs = this.stmt.executeQuery(requete);
        } catch (SQLException ex) {
            Logger.getLogger(Request_MySQL.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        if (this.debug){
            print_resultSet(rs);
        }
        return rs;
    }
    
    /**
     * Renvois le ResultSet correspond à la requete en paramètre
     * @param requete Correspond à la requete SQL
     * @return ResultSet du resultat de la requete
     */
    public int executer_update(String requete) {
        int key = 0;
        if (this.debug){
            System.out.println("DEBUG : REQUETE : "+requete);
        }
        try {
            this.stmt.executeUpdate(requete, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            Logger.getLogger(Request_MySQL.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        ResultSet rs;
        try {
            rs = this.stmt.getGeneratedKeys();
            if(rs.next()){
                key = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Request_MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
  
        return key;
    }
    
    /**
     * Affiche le resultSet en System.out (utile pour le DEBUG)
     * @param rs ResultSet à afficher
     */
    public void print_resultSet(ResultSet rs){
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
                Logger.getLogger(Request_MySQL.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public int taille_resultSet(ResultSet rs) throws SQLException{
        int taille = 0;
        while(rs.next()){
            taille++;
        }
        rs.beforeFirst();
        return taille;
    }
    
}
