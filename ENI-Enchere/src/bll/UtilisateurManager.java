package bll;

import bo.Utilisateur;
import dal.DAOFactory;
import dal.UtilisateurDAO;

public class UtilisateurManager {

	private UtilisateurDAO utilisateurDAO;
	
	public UtilisateurManager() {
		this.utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}
	
	public boolean nouvelUtilisateur(Utilisateur utilisateur) {
		return this.utilisateurDAO.nouvelUtilisateur(utilisateur);
	}
	
	public boolean connexion(String identifiant, String mot_de_passe) {
		return this.utilisateurDAO.connexion(identifiant, mot_de_passe);
	}
	
	public boolean identifiantLibre(String identifiant) {
		return this.utilisateurDAO.identifiantLibre(identifiant);
	}
	
	public boolean emailLibre(String email) {
		return this.utilisateurDAO.emailLibre(email);
	}
}
