package dal;

import java.util.List;

import bo.Utilisateur;

public interface UtilisateurDAO {
	public Utilisateur nouvelUtilisateur(Utilisateur utilisateur);
	
	public boolean connexion(String identifiant, String mot_de_passe);
	
	public boolean identifiantLibre(String identifiant);
	
	public boolean emailLibre(String email);
	
	public Utilisateur getUtilisateurByIdentifiant(String identifiant);

	public List<Utilisateur> selectAll();
}
