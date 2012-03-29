/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edt.Classe;

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
    
    public Inscription (int id) throws SQLException{
        ResultSet rs = BD_MySQL.executer_requete("SELECT * FROM Inscription WHERE id="+id);
        rs.next();
        this.idUE = rs.getInt("idUE");
        this.idEtudiant = rs.getInt("idEtudiant");
    }

    @Override
    public void insert() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet.");
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

    /**
     * @return the idEtudiant
     */
    public int getIdEtudiant() {
        return idEtudiant;
    }

    /**
     * @param idEtudiant the idEtudiant to set
     */
    public void setIdEtudiant(int idEtudiant) {
        this.idEtudiant = idEtudiant;
    }
     
}
