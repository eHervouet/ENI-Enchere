package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bo.Utilisateur;

public class UtilisateurDAOImpl implements UtilisateurDAO {

	@Override
	public Utilisateur nouvelUtilisateur(Utilisateur utilisateur) {
		final String INSERT="INSERT INTO utilisateurs(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES ('"+utilisateur.getPseudo()+"', '"+ utilisateur.getNom()+"', '"+utilisateur.getPrenom()+"', '"+utilisateur.getEmail()+"', '"+utilisateur.getTelephone()+"', '"+utilisateur.getRue()+"', '"+utilisateur.getCode_postal()+"', '"+utilisateur.getVille()+"', '"+utilisateur.getMot_de_passe()+"', 0, "+(utilisateur.getAdministrateur() ? "1" : "0")+");";
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			int i = pstmt.executeUpdate();
			if (i > 0) {
				ResultSet rs = pstmt.getGeneratedKeys();
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
	
	public List<Utilisateur> selectAll(){
		final String SELECT="SELECT * FROM utilisateurs;";
		List<Utilisateur> listeUtilisateurs = new ArrayList<Utilisateur>();
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT);
			
			while(rs.next()) {
				listeUtilisateurs.add(new Utilisateur(
						rs.getInt("no_utilisateur"),
						rs.getString("pseudo"),
						rs.getString("nom"),
						rs.getString("prenom"),
						rs.getString("email"),
						rs.getString("telephone"),
						rs.getString("rue"),
						rs.getString("code_postal"),
						rs.getString("ville"),
						rs.getString("mot_de_passe"),
						rs.getInt("credit"),
						rs.getBoolean("administrateur"),
						true
						));
			}
		} catch(Exception e) {
			System.out.print(e.getMessage());
		}
		
		return listeUtilisateurs;
		
		
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
	
	@Override
	public Utilisateur getUtilisateurByNum(int no_utilisateur) {
		final String SELECT="SELECT * FROM utilisateurs WHERE no_utilisateur = '"+no_utilisateur+"';";
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

	@Override
	public Utilisateur modifierUtilisateur(Utilisateur utilisateur) {
		final String UPDATE="UPDATE Utilisateurs SET pseudo = '"+utilisateur.getPseudo()+"', nom = '"+utilisateur.getNom()+"', prenom = '"+utilisateur.getPrenom()+"', email = '"+utilisateur.getEmail()+"', telephone = '"+utilisateur.getTelephone()+"', rue = '"+utilisateur.getRue()+"', ville = '"+utilisateur.getVille()+"', code_postal = '"+utilisateur.getCode_postal()+"' WHERE no_utilisateur = "+utilisateur.getNo_utilisateur()+";";
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE, Statement.RETURN_GENERATED_KEYS);
			int i = pstmt.executeUpdate();
			if (i > 0) {
				ResultSet rs = pstmt.getGeneratedKeys();
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
	public void supprimerUtilisateur(int no_utilisateur) {
		final String DELETE="DELETE FROM utilisateurs WHERE no_utilisateur = "+no_utilisateur+";";
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(DELETE);
			pstmt.execute();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
}
