package edt.sma_interface;

import java.util.ArrayList;

public interface APIEtudiant {
	/* Retourne les id des UEs suivi par un �tudiant */
	public ArrayList<Integer> getIdUESuivitBDD(int idEtudiant);

	/* Sauvegarde un etudiant */
	//public void savEtudiant(int id, ArrayList<Integer> idUESuivi);
}
