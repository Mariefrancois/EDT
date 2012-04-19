/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edt.mysql;

import edt.sma_interface.APIEdT;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author v-tech_master
 */
public class Edt_MySQL extends BD_MySQL implements APIEdT{
    
    Request_MySQL bdd;

    Edt_MySQL(Request_MySQL request) {
        this.bdd = request;
    }

    @Override
    public Date getDebutPlageHoraireBDD(int idCours) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Date getFinPlageHoraireBDD(int idCours) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getTypeCoursPlageHoraireBDD(int idCours) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void savePlageHoraireBDD(Date deb, Date fin, String type) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Date getDateDebBDD() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Date getDateFinBDD() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Integer> getListeIdCreneauNonExploitableBDD() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Integer> getListIdPlageHoraireBDD() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void saveContrainteEDT(Date debSem, Date finSem) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Date getCreneauExploiteDebBDD(int idJourNonOuvrable) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Date getCreneauExploiteFinBDD(int idJourNonOuvrable) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getTypeCreneauNonExploitableBDD(int idJourNonOuvrable) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   

    
    
    
}
