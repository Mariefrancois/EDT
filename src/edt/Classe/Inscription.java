/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edt.Classe;

import edt.mysql.BD_MySQL;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author v-tech_master
 */
public class Inscription implements Model_JDBC{
    
    private int idUE;
    private int idEtudiant;
    
    public Inscription(UE ue, Etudiant etudiant){
        this.idEtudiant = etudiant.getId();
        this.idUE = ue.getId();
    }

    /**
     * @return the idUE
     */
    public int getIdUE() {
        return idUE;
    }

    /**
     * @return the idEtudiant
     */
    public int getIdEtudiant() {
        return idEtudiant;
    }

    @Override
    public void save() {
        String requete;
        
        requete = "INSERT INTO Inscription (idUE, idEtudiant) "
                + "VALUES ('"+this.idUE
                +"', '"+this.idEtudiant
                +"')";
        
        BD_MySQL.executer_update(requete);
    }

    @Override
    public void delete() {
         String requete;   

        requete = "DELETE FROM Inscription "
                +" WHERE id='"+this.idUE+"' AND idEtudiant='"+this.idEtudiant+"';";
        
        this.idUE = BD_MySQL.executer_update(requete);
    }
     
}
