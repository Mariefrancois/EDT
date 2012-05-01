/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edt.mysql;

import edt.sma_interface.APIEtudiant;
import java.util.ArrayList;

/**
 *
 * @author v-tech_master
 */
public class Etudiant_MySQL extends BD_MySQL implements APIEtudiant {
    
    Request_MySQL bdd;

    Etudiant_MySQL(Request_MySQL request) {
        this.bdd = request;
    }

    @Override
    public ArrayList<Integer> getIdUESuivitBDD(int idEtudiant) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
