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

    @Override
    public int getNbCoursBDD(int idUE) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getNbTdBDD(int idUE) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getNbTpBDD(int idUE) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Integer> getIdSeanceBDD(int idUE) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getIdPrecedentSeanceBDD(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getDureeSeanceBDD(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getCapaciteSeanceBDD(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getTypeSeanceBDD(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean getEffectueeSeanceBDD(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Integer> getListeIdContrainteSalleSeanceBDD() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void saveSeance(int IDseance, int IDprecedent, int IDduree, int IDcapacite, int IDtype, boolean Effect, ArrayList<Integer> IDcontrainteSalle) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
