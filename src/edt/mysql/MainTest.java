/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edt.mysql;

/**
 *
 * @author v-tech_master
 */
public class MainTest {
    
    public static void main(String[] args){
        Connection_MySQL bdd = new Connection_MySQL(1, "root", "rose");
        System.out.println(bdd.etudiant.getIdUESuivitBDD(1));
    }
    
}
