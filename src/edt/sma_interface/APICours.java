package edt.sma_interface;

import java.util.ArrayList;

public interface APICours {
	/* Retourne le nombre de s�ances de cours d�une UE */
	public ArrayList<Integer> getidSeanceCoursBDD(int idUE);

	/* Retourne le nombre de s�ances de TD d�une UE */
	public ArrayList<Integer> getidSeanceTdBDD(int idUE);

	/* Retourne le nombre de s�ances de TP d�une UE */
	public ArrayList<Integer> getidSeanceTpBDD(int idUE);

	/* Retourne les id des s�ances d�une UE */
	//public ArrayList<Integer> getIdSeanceBDD(int idUE);

	/* Enregistre une UE */
	//public void saveUE(int NbSeanceCoursUE, int NbSeanceTdUE, int NbSeanceTpUE,
			//ArrayList<Integer> IDSeanceUE);

	/* Retourne l�id de la seance qui doit preceder cette seance */
	public int getIdPrecedentSeanceBDD(int idSeance);

	/* Retourne la duree d�une seance */
	public int getDureeSeanceBDD(int idSeance);

	/* Retourne la capacite (nombre d�etudiant possible) d�une seance */
	public int getCapaciteSeanceBDD(int idSeance);

	/* Retourne le type d�une seance */
	public int getTypeSeanceBDD(int idSeance);

	/* Retourne un booleen exprimant le fait qu�une seance est effectuee ou non */
	public boolean getEffectueeSeanceBDD(int idSeance);

	/* Retourne la liste des id des contraintes de salle d�une seance */
	public ArrayList<Integer> getListeIdContrainteSalleSeanceBDD(int idSeance);

	/* Enregistre une seance */
	//public void saveSeance(int IDseance, int IDprecedent, int IDduree,
			//int IDcapacite, int IDtype, boolean Effect,
			//ArrayList<Integer> IDcontrainteSalle);
}
