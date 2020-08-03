package dal;

import java.util.ArrayList;
import java.util.List;

import bo.Categorie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CategorieDAOImpl implements CategorieDAO {
	
	@Override
	public List<Categorie> selectAll() {
		final String SELECT="SELECT * FROM categories;";
		List<Categorie> lc = new ArrayList<Categorie>();
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT);
			
			while(rs.next()) {
				lc.add(new Categorie(rs.getInt("no_categorie"), rs.getString("libelle")));
			}
		} catch(Exception e) {
			System.out.print(e.getMessage());
		}
		
		return lc;
	}
}
