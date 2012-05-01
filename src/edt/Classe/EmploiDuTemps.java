/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edt.Classe;

import edt.mysql.BD_MySQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author kal747
 */
public class EmploiDuTemps {
    
    /**
     * Renvoi la liste des id de cours d'une promotion entre deux timestamp
     * @param idPromotion
     * @param debut
     * @param fin
     * @return
     * @throws SQLException 
     */
    public static ArrayList<Integer> liste_id_cours_promotion_entre_dates(
            int idPromotion, Timestamp debut, Timestamp fin) throws SQLException {
        ArrayList<Integer> listeIds = new ArrayList();
        
        String requete = "SELECT idCours FROM V_Cours_Promotion WHERE tsDebut > '" + debut + "' AND tsFin < '" + fin + "' ORDER BY tsDebut;";
        ResultSet rs = BD_MySQL.executer_requete(requete);
        while(rs.next()){
            listeIds.add(rs.getInt("idCours"));
        }
        
        return listeIds;
    }
    
    public static String intDay_to_String(int day) {
        String[] days = {
            "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi"
        };
        return days[day-1];
    }
    
    public static HashMap<String, ArrayList<Cours>> liste_cours_promotion_semaine(int idPromotion, Timestamp debutSemaine) throws SQLException {
        HashMap<String, ArrayList<Cours>> liste = new HashMap();
        liste.put("Lundi", new ArrayList<Cours>());
        liste.put("Mardi", new ArrayList<Cours>());
        liste.put("Mercredi", new ArrayList<Cours>());
        liste.put("Jeudi", new ArrayList<Cours>());
        liste.put("Vendredi", new ArrayList<Cours>());
        liste.put("Samedi", new ArrayList<Cours>());
        ArrayList<Integer> idCours = 
                EmploiDuTemps.liste_id_cours_promotion_entre_dates(
                    idPromotion, 
                    debutSemaine, 
                    new Timestamp(
                            debutSemaine.getTime() + ((7 * 24 * 3600 * 1000) - 1)
                            )
                );
        
        for (int id : idCours) {
            Cours c = new Cours(id);
            String jourDebut = 
                    EmploiDuTemps.intDay_to_String(c.getTsDebut().getDay());  
            String jourFin = 
                    EmploiDuTemps.intDay_to_String(c.getTsFin().getDay()); 
            if (jourDebut.equals(jourFin)) {
                // Ajout du cours dans la liste
                liste.get(jourDebut).add(c);
            } else {
                // Gérer les cours sur plusieurs jours (les divisers)
            }
        }
        
        return liste;
    }
    
    public static String cours_semaine_promotion_html_table(int idPromotion, Timestamp debutSemaine) throws SQLException {
        String[] jours = {
            "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi"
        };
        HashMap<String, ArrayList<Cours>> listeCours = EmploiDuTemps.liste_cours_promotion_semaine(idPromotion, debutSemaine);
        
        String code = "";
        code += "<table class=\"edt_semaine\">\n";
        code += "\t<tr>\n";
        code += "\t\t<th>Jour \\ Heure</th>\n";
        for (int h = 7; h < 20; h++) {
            code += "\t\t<th>" + h + "</th><th></th><th></th><th></th>\n";
        }
        code += "\t</tr>\n";
        code += "</table>\n";
        
        return code;
    }
    
    /**.
     * Renvoi le code HTML correspondant à la transformation d'un cours en <td>
     * @param c : Cours à transformer
     * @return String : Code HTML correspondant au <td> du cours
     */
    public static String cours_to_html_td(Cours c) {
        String td = 
         "<td "
                + "class=\"" + c.getNomTypeCours() + "\" "
                + "colspan=\"" + c.nombre_de_quart_heure() + "\" "
                + ">";
        td += c.getNomUE();
        td += "</td>";
        
        return "";
    }
    
    
    
    public static void main(String[] args) throws SQLException, ParseException {
        BD_MySQL.init();
        
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long timeDebut = formatter.parse("2012-02-06 00:00:00").getTime();
        String codeHtml = EmploiDuTemps.cours_semaine_promotion_html_table(4, new Timestamp(timeDebut));
        System.out.println(codeHtml);
    }
    
}
