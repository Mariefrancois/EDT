/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edt.mysql;

import edt.sma_interface.APIEnseignant;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author v-tech_master
 */
public class Enseignant_MySQL extends BD_MySQL implements APIEnseignant {

    Request_MySQL bdd;
    
    Enseignant_MySQL(Request_MySQL request) {
        this.bdd = request;
    }

    @Override
    public ArrayList<Integer> getListeIdSeanceEnseignantBDD(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Integer> getListeIdContrainteDispoEnseignantBDD(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Date getDateDebutContrainteDispoBDD(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Date getDateFinContrainteDispoBDD(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void savContrainteDispo(int id, Date deb, Date fin) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    
}
