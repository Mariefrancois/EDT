package edt.sma_interface;

import java.util.ArrayList;
import java.util.Date;

public interface APIEdT {
	/* Retourne le debut d�une plage horaire (id) */
	public Date getDebutPlageHoraireBDD(int id);

	/* Retourne la fin d�une plage horaire (id) */
	public Date getFinPlageHoraireBDD(int id);

	/* Retourne le type de cours d�une plage horaire */
	public String getTypeCoursPlageHoraireBDD(int id);

	/* Enregistre une plage horaire (retourne l�ID) */
	public void savePlageHoraireBDD(Date deb, Date fin, String type);

	/* Retourne le numero de l�emploi du temps */
	public int getIdEDTBDD();

	/* Retourne la date de debut du semestre */
	public Date getDateDebBDD();

	/* Retourne la date de fin du semestre */
	public Date getDateFinBDD();

	/* Retourne la liste des id des cr�neaux non exploitable */
	public ArrayList<Integer> getListeIdCreneauNonExploitableBDD();

	/* Retourne la liste des IDs des Plages Horaires de l�EDT */
	public ArrayList<Integer> getListIdPlageHoraireBDD();

	/* Enregistre un emploi du temps */
	public void saveEDT(int idEDT, int numeroEDT, Date debSem, Date finSem,
			ArrayList<Integer> creneauNonExp, ArrayList<Integer> listeHoraire);

	/*
	 * Retourne la date de debut d�un creneau non exploitable donne en parametre
	 * (son id)
	 */
	public Date getCreneauExploiteDebBDD(int id);

	/*
	 * Retourne la date de fin d�un creneau non exploitable donne en parametre
	 * (son id)
	 */
	public Date getCreneauExploiteFinBDD(int id);

	/* Retourne le type de creneau non exploitable */
	public String getTypeCreneauNonExploitableBDD(int id);

	/* Sauvegarde un Creneau Non Exploitable */
	///public void savCreneauNonExploitable(int id, Date def, Date fin, String type);
}
