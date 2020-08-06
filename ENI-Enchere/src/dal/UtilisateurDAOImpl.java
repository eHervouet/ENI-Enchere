package dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.sun.org.apache.xpath.internal.operations.Mod;

import bo.Utilisateur;

public class UtilisateurDAOImpl implements UtilisateurDAO {

	@Override
	public Utilisateur nouvelUtilisateur(Utilisateur utilisateur) {
		final String INSERT="INSERT INTO utilisateurs(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES ('"+utilisateur.getPseudo()+"', '"+ utilisateur.getNom()+"', '"+utilisateur.getPrenom()+"', '"+utilisateur.getEmail()+"', '"+utilisateur.getTelephone()+"', '"+utilisateur.getRue()+"', '"+utilisateur.getCode_postal()+"', '"+utilisateur.getVille()+"', '"+utilisateur.getMot_de_passe()+"', 0, "+(utilisateur.getAdministrateur() ? "1" : "0")+");";
		boolean vreturn = false;
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			Statement stmt = cnx.createStatement();
			int i = stmt.executeUpdate(INSERT);
			if (i > 0) {
				ResultSet rs = stmt.getGeneratedKeys();
				rs.next();
				utilisateur.setNo_utilisateur(rs.getInt(1));
				utilisateur.setIsInBase(true);
			}
			
		} catch(Exception e) {
			System.out.print(e.getMessage());
		}
		return utilisateur;
	}
	
	@Override
	public boolean connexion(String identifiant, String mot_de_passe) {
		final String SELECT="SELECT COUNT(*) as count FROM utilisateurs WHERE pseudo = '"+identifiant+"' AND mot_de_passe = '"+mot_de_passe+"'";
		boolean vreturn = false;
		try(Connection cnx = ConnectionProvider.getConnection()) {
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT);

			rs.next();
			
			if(rs.getInt("count") > 0) {
				vreturn = true;
			}
			
		} catch(Exception e) {
			System.out.print(e.getMessage());
		}
		
		return vreturn;
	}
	
	@Override
	public boolean identifiantLibre(String identifiant) {
		final String SELECT="SELECT COUNT(*) as count FROM utilisateurs WHERE pseudo = '"+identifiant+"';";
		boolean vreturn = true;
		try(Connection cnx = ConnectionProvider.getConnection()) {
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT);

			rs.next();
			
			if(rs.getInt("count") > 0) {
				vreturn = false;
			}
			
		} catch(Exception e) {
			System.out.print(e.getMessage());
		}
		
		return vreturn;
	}
	
	@Override
	public boolean emailLibre(String email) {
		final String SELECT="SELECT COUNT(*) as count FROM utilisateurs WHERE email = '"+email+"';";
		boolean vreturn = true;
		try(Connection cnx = ConnectionProvider.getConnection()) {
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT);

			rs.next();
			
			if(rs.getInt("count") > 0) {
				vreturn = false;
			}
			
		} catch(Exception e) {
			System.out.print(e.getMessage());
		}
		
		return vreturn;
	}

	@Override
	public Utilisateur getUtilisateurByIdentifiant(String identifiant) {
		final String SELECT="SELECT * FROM utilisateurs WHERE pseudo = '"+identifiant+"';";
		Utilisateur u = null;
				
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT);
			rs.next();
			u = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"), rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"), rs.getString("mot_de_passe"), rs.getInt("credit"), rs.getBoolean("administrateur"), true);
		} catch(Exception e) {
			System.out.print(e.getMessage());
		}
		
		return u;
	}
}
