package edt.sma_interface;

import java.util.ArrayList;

public interface APIMain {
	/* Retourne la liste des id des etudiants */
	public ArrayList<Integer> getListIdEtudiantBDD();

	/* Retourne la liste des id des enseignants */
	public ArrayList<Integer> getListeIdEnseignantBDD();

	/* Retourne la liste des id des emplois du temps generee */
	public ArrayList<Integer> getListeIdEDTBDD();

	/* Retourne la liste des id des UEs */
	public ArrayList<Integer> getListIdUEBDD();
}
