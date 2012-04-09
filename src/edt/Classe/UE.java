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
 * @author Marie
 */
public class UE implements Model_JDBC {
    private int id;
    private String nom;
    private String intitule;
    private int nbHeuresCours;
    private int nbHeuresTD;
    private int nbHeuresTP;
    private int ECTS;
    private int idPromotion;
    private int idIntervenant;
    
    public UE(String nom, String intitule, int nbHeuresCours, int nbHeuresTD, int nbHeuresTP, int ECTS, int idPromotion){
        this.id = 0;
        this.nom = nom;
        this.intitule = intitule;
        this.nbHeuresCours = nbHeuresCours;
        this.nbHeuresTD = nbHeuresTD;
        this.nbHeuresTP = nbHeuresTP;
        this.ECTS = ECTS;
        this.idPromotion = idPromotion;
        this.idIntervenant = 1;
    }
 
    
    public UE(int id) throws SQLException{
        ResultSet rs = BD_MySQL.executer_requete("SELECT * FROM UE WHERE id="+id);
        rs.next();
        this.id = rs.getInt("id");
        this.nom = rs.getString("nom");
        this.intitule = rs.getString("intitule");
        this.nbHeuresCours = rs.getInt("nbHeuresCours");
        this.nbHeuresTD = rs.getInt("nbHeuresTD");
        this.nbHeuresTP = rs.getInt("nbHeuresTP");
        this.ECTS = rs.getInt("ECTS");
        this.idIntervenant = rs.getInt("idResponsable");
        this.idPromotion = rs.getInt("idPromotion");
    }
    
    public int getId() {
        return id;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public int getNbHeuresCours() {
        return nbHeuresCours;
    }

    public void setNbHeuresCours(int nbHeuresCours) {
        this.nbHeuresCours = nbHeuresCours;
    }

    public int getNbHeuresTD() {
        return nbHeuresTD;
    }

    public void setNbHeuresTD(int nbHeuresTD) {
        this.nbHeuresTD = nbHeuresTD;
    }

    public int getNbHeuresTP() {
        return nbHeuresTP;
    }

    public void setNbHeuresTP(int nbHeuresTP) {
        this.nbHeuresTP = nbHeuresTP;
    }

    public int getECTS() {
        return ECTS;
    }

    public void setECTS(int ECTS) {
        this.ECTS = ECTS;
    }
    
    public int getIdPromotion() {
        return idPromotion;
    }
    
    public void setIdPromotion(int idPromotion) {
        this.idPromotion = idPromotion;
    }
    
    public int getIdIntervenant() {
        return idIntervenant;
    }
    
    public void setIdIntervenant(int idIntervenant) {
        this.idIntervenant = idIntervenant;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UE other = (UE) obj;
        if (this.id != other.id) {
            return false;
        }
        if ((this.nom == null) ? (other.nom != null) : !this.nom.equals(other.nom)) {
            return false;
        }
        if ((this.intitule == null) ? (other.intitule != null) : !this.intitule.equals(other.intitule)) {
            return false;
        }
        if (this.nbHeuresCours != other.nbHeuresCours) {
            return false;
        }
        if (this.nbHeuresTD != other.nbHeuresTD) {
            return false;
        }
        if (this.nbHeuresTP != other.nbHeuresTP) {
            return false;
        }
        if (this.ECTS != other.ECTS) {
            return false;
        }
        if (this.idPromotion != other.idPromotion) {
            return false;
        }
        if (this.idIntervenant != other.idIntervenant) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 97 * hash + (this.nom != null ? this.nom.hashCode() : 0);
        hash = 97 * hash + (this.intitule != null ? this.intitule.hashCode() : 0);
        hash = 97 * hash + this.nbHeuresCours;
        hash = 97 * hash + this.nbHeuresTD;
        hash = 97 * hash + this.nbHeuresTP;
        hash = 97 * hash + this.ECTS;
        hash = (int) (97 * hash + this.idPromotion);
        hash = 97 * hash + this.idIntervenant;
        return hash;
    }

    @Override
    public void save() {
         String requete;
        
        if(this.getId() == 0){
            requete = "INSERT INTO UE (nom, intitule, nbHeuresCours, nbHeuresTD, nbHeuresTP, ECTS, idResponsable, idPromotion) "
                    + "VALUES ('"+this.nom
                    +"', '"+this.intitule
                    +"', "+this.nbHeuresCours
                    +", "+this.nbHeuresTD
                    +", "+this.nbHeuresTP
                    +", "+this.ECTS
                    +", "+this.idIntervenant
                    +", "+this.idPromotion
                    +");";
        }else{
            requete = "UPDATE UE SET "
                    + "nom='"+this.nom
                    +"', intitule="+this.intitule
                    +", nbHeuresCours='"+this.nbHeuresCours
                    +"', nbHeuresTD='"+this.nbHeuresTD
                    +"', nbHeuresTP='"+this.nbHeuresTP
                    +"', ECTS='"+this.ECTS
                    +"', idPromotion='"+this.idPromotion
                    +"', idResponsable='"+this.idIntervenant
                    +"' WHERE id='"+this.getId()+"'";
        }
        
        this.id = BD_MySQL.executer_update(requete);
    }

    @Override
    public void delete() {
         String requete;                                      
        BD_MySQL.init();

        requete = "DELETE FROM UE "
                +" WHERE id='"+this.id+"';";
        
        this.id = BD_MySQL.executer_update(requete);
    }
}
