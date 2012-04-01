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

    @Override
    public Date getDebutPlageHoraireBDD(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Date getFinPlageHoraireBDD(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getTypeCoursPlageHoraireBDD(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void savePlageHoraireBDD(Date deb, Date fin, String type) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getIdEDTBDD() {
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
    public void saveEDT(int idEDT, int numeroEDT, Date debSem, Date finSem, ArrayList<Integer> creneauNonExp, ArrayList<Integer> listeHoraire) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Date getCreneauExploiteDebBDD(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Date getCreneauExploiteFinBDD(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getTypeCreneauNonExploitableBDD(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
