package bll;

import java.util.List;

import bo.Enchere;
import bo.Utilisateur;
import dal.DAOFactory;
import dal.UtilisateurDAO;

public class UtilisateurManager {

	private UtilisateurDAO utilisateurDAO;
	
	public UtilisateurManager() {
		this.utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}
	
	public Utilisateur nouvelUtilisateur(Utilisateur utilisateur) {
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
	

	public Utilisateur getUtilisateurByIdentifiant(String identifiant) {
		return this.utilisateurDAO.getUtilisateurByIdentifiant(identifiant);
	}

	public Utilisateur getUtilisateurByNum(int no_utilisateur) {
		return this.utilisateurDAO.getUtilisateurByNum(no_utilisateur);
	}
	
	public List<Utilisateur> selectAll() {
		return this.utilisateurDAO.selectAll();
	}
	
	public Utilisateur modifierUtilisateur(Utilisateur utilisateur) {
		return this.utilisateurDAO.modifierUtilisateur(utilisateur);
	}
	
	public void supprimerUtilisateur(int no_utilisateur) {
		this.utilisateurDAO.supprimerUtilisateur(no_utilisateur);
	}
}
