package dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import bo.Utilisateur;

public class UtilisateurDAOImpl implements UtilisateurDAO {

	@Override
	public void nouvelUtilisateur(Utilisateur utilisateur) {
		final String INSERT="INSERT INTO utilisateurs(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES ('"+utilisateur.getPseudo()+"', '"+ utilisateur.getNom()+"', '"+utilisateur.getPrenom()+"', '"+utilisateur.getEmail()+"', '"+utilisateur.getTelephone()+"', '"+utilisateur.getRue()+"', '"+utilisateur.getCode_postal()+"', '"+utilisateur.getVille()+"', '"+utilisateur.getMot_de_passe()+"', 0, "+(utilisateur.getAdministrateur() ? "1" : "0")+");";
		System.out.print(INSERT);
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(INSERT);
			
		} catch(Exception e) {
			System.out.print(e.getMessage());
		}
	}

}
