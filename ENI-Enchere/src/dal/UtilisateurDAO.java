package dal;

import bo.Utilisateur;

public interface UtilisateurDAO {
	public boolean nouvelUtilisateur(Utilisateur utilisateur);
	
	public boolean connexion(String identifiant, String mot_de_passe);
}
