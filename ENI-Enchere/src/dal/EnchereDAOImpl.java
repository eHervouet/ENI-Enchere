package dal;

import java.util.ArrayList;
import java.util.List;

import bo.Categorie;
import bo.Enchere;

import java.sql.Connection;
import java.sql.Date;
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

	@Override
	public boolean ajouterEnchere(Enchere ench) {
		final String INSERT_ENCHERES="INSERT INTO ENCHERES(no_utilisateur, no_article, date_enchere, montant_enchere) "
			+ "VALUES ("+ench.getNo_utilisateur()+", "+ ench.getNo_article()+", '"+ench.getDate_enchere()+"', "+ench.getMontant_enchere()+");";
		
		boolean vreturn = false;
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			Statement stmt = cnx.createStatement();
			int i = stmt.executeUpdate(INSERT_ENCHERES);
			if (i > 0) {
				vreturn = true;
			}
			
		} catch(Exception e) {
			System.out.print(e.getMessage());
		}
		return vreturn;
	}
	

}
