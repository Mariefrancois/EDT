package edt.sma_interface;

import java.util.ArrayList;
import java.util.Date;

public interface APIEnseignant {
	/* Retourne la liste des id des seances que l�enseignant dirige */
	public ArrayList<Integer> getListeIdSeanceEnseignantBDD(int idEnseignant);

	/* Retourne la liste des id des contraintes de disponibilite de l�enseignant */
	public ArrayList<Integer> getListeIdContrainteDispoEnseignantBDD(int idEnseignant);

	/* Sauvegarde un enseignant */
	//public void savEnseignant(int id, ArrayList<Integer> listIdSeance,
			//ArrayList<Integer> listIdContrainteDispo);

	/*
	 * Retourne la date de debut d�une contrainte de disponibilite identifiee
	 * par son id
	 */
	public Date getDateDebutContrainteDispoBDD(int idCreanaux_intervenant);

	/*
	 * Retourne la date de fin d�une contrainte de disponibilite identifiee par
	 * son id
	 */
	public Date getDateFinContrainteDispoBDD(int idCreanaux_intervenant);

	/* Sauvegarde une ContrainteDispo */
	public void savContrainteDispo(int idEnseignant, Date deb, Date fin);
}
