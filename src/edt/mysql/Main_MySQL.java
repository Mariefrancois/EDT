/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edt.mysql;

import edt.sma_interface.APIMain;
import java.util.ArrayList;

/**
 *
 * @author v-tech_master
 */
class Main_MySQL implements APIMain {
    
    Request_MySQL bdd;

    public Main_MySQL(Request_MySQL request) {
        this.bdd = request;
    }

    @Override
    public ArrayList<Integer> getListIdEtudiantBDD() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Integer> getListeIdEnseignantBDD() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Integer> getListIdUEBDD() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   
    
}
