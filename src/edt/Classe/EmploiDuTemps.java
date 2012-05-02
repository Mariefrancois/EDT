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
        // Debut du tableau
        code += "<table class=\"edt_semaine\">\n";
        
        // En tête
        code += "\t<tr>\n";
        code += "\t\t<th>Jour \\ Heure</th>\n";
        for (int h = 7; h <= 20; h++) {
            code += "\t\t<th>" + h + "</th>\n\t\t<th></th>\n\t\t<th></th>\n\t\t<th></th>\n";
        }
        code += "\t</tr>\n";
        
        // Corps du tableau (semaine)
        for (String j : jours) {
            ArrayList<Cours> coursDuJours = listeCours.get(j);
            boolean premierParcours = true; // Gestion des conflits
            while (premierParcours || coursDuJours.size() > 0) {
                code += "\t<tr>\n";
                
                // Affichage du jour si premier parcours
                if (premierParcours) {
                    code += "\t\t<td>"+j+"</td>\n";
                } else {
                    code += "\t\t<td></td>\n";
                }
                
                int nbQuartsHeure = 0;
                while (nbQuartsHeure < (14 * 4)) {
                    int heure = 7 + ((int)(nbQuartsHeure / 4));
                    int quart = nbQuartsHeure % 4;
                    String strHeure = "";
                    if(heure < 10) {
                        strHeure += "0" + heure;
                    } else {
                        strHeure += heure;
                    }
                    switch (quart) {
                        case 0 : strHeure += ":00:00";
                        case 1 : strHeure += ":15:00";
                        case 2 : strHeure += ":30:00";
                        case 3 : strHeure += ":45:00";
                        default : strHeure += ":00:00";
                    }
                    boolean boolCours = false;
                    for (Cours c : coursDuJours) {
                        if (c.commence_a_heure(strHeure)) {
                            boolCours = true;
                            code += "\t\t" + EmploiDuTemps.cours_to_html_td(c);
                            int nbQuartsCours = c.nombre_de_quart_heure();
                            nbQuartsHeure += nbQuartsCours;
                            coursDuJours.remove(c);
                            break; // Je sors du for
                        }
                    }
                    if(!boolCours) {
                        code += "\t\t<td></td>\n";
                        nbQuartsHeure ++;
                    }
                }
                premierParcours = false;
                
                code += "\t</tr>\n";
            }
        }
        
        // Fin du tableau
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
        td += "</td>\n";
        
        return td;
    }
    
    public static String cours_semaine_promotion_html(int idPromotion, Timestamp debutSemaine) throws SQLException {
        String code ="";
        code += "<!DOCTYPE html>\n";
        code += "<head>\n";
        code += "<meta charset=\"utf-8\" />\n";
        code += "<style type=\"text/css\">\n";
        
        code += "table.edt_semaine { margin: 0px auto 0px auto; border: solid 1px black; ]";
        
        code += "</style>\n";
        code += "</head>\n";
        code += "<body>\n";
        code += EmploiDuTemps.cours_semaine_promotion_html_table(idPromotion, debutSemaine);
        code += "</body>\n";
        code += "</html>\n";
        return code;
    }
    
}
