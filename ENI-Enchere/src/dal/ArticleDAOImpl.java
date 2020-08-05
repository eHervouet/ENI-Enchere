package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bo.Article;
import bo.Enchere;

public class ArticleDAOImpl implements ArticleDAO {
	
	private static final String SELECT_ARTICLE="SELECT * FROM ARTICLES WHERE no_article = ?;";
			
	@Override
	public void nouvelArticle(Article article)
	{
		final String INSERT_ARTICLE="";
		
		System.out.print(INSERT_ARTICLE);
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(INSERT_ARTICLE);
			
		} catch(Exception e) {
			System.out.print(e.getMessage());
		}
	}

	@Override
	public Article getArticleById(int no_article) {
		Article article = null;
		try(Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ARTICLE);
			pstmt.setInt(1, no_article);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                 article = new Article(rs.getInt("no_article"),
                                 rs.getString("nom_article"),
                                 rs.getString("description"),
                                 rs.getDate("date_debut_encheres"),
                                 rs.getDate("date_fin_encheres"),
                                 rs.getInt("prix_initial"),
                                 rs.getInt("prix_vente"),
                                 rs.getInt("no_utilisateur"),
                                 rs.getInt("no_categorie"),
                                 rs.getString("path_photo"));
            }
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return article;
	}

	@Override
	public List<Article> selectAll() {
		final String SELECT="SELECT * FROM articles;";
		List<Article> listeArticles = new ArrayList<Article>();
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT);
			
			while(rs.next()) {
				listeArticles.add(new Article(
						rs.getInt("no_article"),
						rs.getString("nom_article"),
						rs.getString("description"),
						rs.getDate("date_debut_encheres"),
						rs.getDate("date_fin_encheres"),
						rs.getInt("prix_initial"),
						rs.getInt("prix_vente"),
						rs.getInt("no_utilisateur"),
						rs.getInt("no_categorie"),
						rs.getString("path_photo")));					
			}
		} catch(Exception e) {
			System.out.print(e.getMessage());
		}
		
		return listeArticles;
		
	}
}
