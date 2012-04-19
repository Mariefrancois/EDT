/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edt.mysql;

import edt.sma_interface.APICours;
import java.util.ArrayList;

/**
 *
 * @author v-tech_master
 */
public class Cours_MySQL extends BD_MySQL implements APICours {
    
    Request_MySQL bdd;

    Cours_MySQL(Request_MySQL request) {
        this.bdd = request;
    }

    @Override
    public ArrayList<Integer> getidSeanceCoursBDD(int idUE) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Integer> getidSeanceTdBDD(int idUE) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Integer> getidSeanceTpBDD(int idUE) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getIdPrecedentSeanceBDD(int idSeance) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getDureeSeanceBDD(int idSeance) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getCapaciteSeanceBDD(int idSeance) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getTypeSeanceBDD(int idSeance) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean getEffectueeSeanceBDD(int idSeance) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Integer> getListeIdContrainteSalleSeanceBDD(int idSeance) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    

    
    
}
