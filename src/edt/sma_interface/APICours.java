package edt.sma_interface;

import java.util.ArrayList;

public interface APICours {
	/* Retourne le nombre de s�ances de cours d�une UE */
	public int getNbCoursBDD(int idUE);

	/* Retourne le nombre de s�ances de TD d�une UE */
	public int getNbTdBDD(int idUE);

	/* Retourne le nombre de s�ances de TP d�une UE */
	public int getNbTpBDD(int idUE);

	/* Retourne les id des s�ances d�une UE */
	public ArrayList<Integer> getIdSeanceBDD(int idUE);

	/* Enregistre une UE */
	//public void saveUE(int NbSeanceCoursUE, int NbSeanceTdUE, int NbSeanceTpUE,
			//ArrayList<Integer> IDSeanceUE);

	/* Retourne l�id de la seance qui doit preceder cette seance */
	public int getIdPrecedentSeanceBDD(int id);

	/* Retourne la duree d�une seance */
	public int getDureeSeanceBDD(int id);

	/* Retourne la capacite (nombre d�etudiant possible) d�une seance */
	public int getCapaciteSeanceBDD(int id);

	/* Retourne le type d�une seance */
	public int getTypeSeanceBDD(int id);

	/* Retourne un booleen exprimant le fait qu�une seance est effectuee ou non */
	public boolean getEffectueeSeanceBDD(int id);

	/* Retourne la liste des id des contraintes de salle d�une seance */
	public ArrayList<Integer> getListeIdContrainteSalleSeanceBDD();

	/* Enregistre une seance */
	public void saveSeance(int IDseance, int IDprecedent, int IDduree,
			int IDcapacite, int IDtype, boolean Effect,
			ArrayList<Integer> IDcontrainteSalle);
}
