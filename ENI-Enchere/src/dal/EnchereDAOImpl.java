package dal;

import java.util.ArrayList;
import java.util.List;

import bo.Categorie;
import bo.Enchere;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class EnchereDAOImpl implements EnchereDAO {

	@Override
	public List<Enchere> selectAll() {
		final String SELECT="SELECT * FROM encheres;";
		List<Enchere> listeEncheres = new ArrayList<Enchere>();
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT);
			
			while(rs.next()) {
				listeEncheres.add(new Enchere(rs.getInt("no_utilisateur"),rs.getInt("no_article"), rs.getDate("date_enchere"), rs.getFloat("montant_enchere")));
			}
		} catch(Exception e) {
			System.out.print(e.getMessage());
		}
		
		return listeEncheres;
		
	}
	

}
