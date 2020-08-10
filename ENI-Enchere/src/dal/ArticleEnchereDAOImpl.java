package dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bo.Article;
import bo.ArticleEnchere;
import bo.Categorie;

public class ArticleEnchereDAOImpl implements ArticleEnchereDAO {

	@Override
	public List<ArticleEnchere> selectAll() {
		final String SELECT="SELECT Articles.no_article, no_categorie, nom_article, montant_enchere, date_fin_encheres, pseudo, path_photo "
				+ "FROM Encheres"
				+ " inner join Articles on Encheres.no_article = Articles.no_article"
				+ "	inner join  UTILISATEURS on UTILISATEURS.no_utilisateur = ENCHERES.no_utilisateur;";
		List<ArticleEnchere> lae = new ArrayList<ArticleEnchere>();
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT);
			
			while(rs.next()) {
				lae.add(new ArticleEnchere(rs.getInt("no_article"),rs.getInt("no_categorie"),rs.getString("nom_article"), rs.getFloat("montant_enchere"), rs.getDate("date_fin_encheres"), rs.getString("pseudo"), rs.getString("path_photo")));
			}
		} catch(Exception e) {
			System.out.print(e.getMessage());
		}
		
		return lae;
	}

}
