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
 * @author kal747
 */
public class EmploiDuTemps {
    
    public static ArrayList<Integer> liste_id_cours_promotion_entre_dates(
            int idPromotion, Timestamp debut, Timestamp fin) throws SQLException {
        ArrayList<Integer> listeIds = new ArrayList();
        
        String requete = "SELECT id FROM V_Cours_Promotion WHERE tsDebut > X AND tsFin < Y ORDER BY tsDebut;";
        ResultSet rs = BD_MySQL.executer_requete(requete);
        while(rs.next()){
            listeIds.add(rs.getInt("id"));
        }
        
        return listeIds;
    }
    
    /**.
     * Renvoi le code HTML correspondant à la transformation d'un cours en <td>
     * @param c : Cours à transformer
     * @return String : Code HTML correspondant au <td> du cours
     */
    public static String cours_to_td(Cours c) {
        String td = 
         "<td "
                + "class=\"" + c.getNomTypeCours() + "\" "
                + "colspan=\"" + c.nombre_de_quart_heure() + "\" "
                + ">";
        td += c.getNomUE();
        td += "</td>";
        
        return "";
    }
    
    public static void main(String[] args) {
        System.out.println("hop");
    }
    
}
