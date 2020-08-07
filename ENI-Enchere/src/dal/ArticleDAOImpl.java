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
	public boolean nouvelArticle(Article article)
	{
		final String INSERT_ARTICLE="INSERT INTO ARTICLES(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial,"
				+ " prix_vente, path_photo, no_categorie, no_utilisateur) "
			+ "VALUES ('"+article.getNom_article()+"', '"+ article.getDescription()+"', '"+article.getDate_debut_encheres()+"',"
				+ "'"+article.getDate_fin_encheres()+"', "+article.getPrix_initial()+", "+article.getPrix_vente()+", "
				+ "'"+article.getPath_photo()+"', "+article.getNo_categorie()+", "+article.getNo_utilisateur()+");";

		boolean vreturn = false;
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			Statement stmt = cnx.createStatement();
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_ARTICLE, Statement.RETURN_GENERATED_KEYS);
			//int i = stmt.executeUpdate(INSERT_ARTICLE);
			int i = pstmt.executeUpdate();
			if (i > 0) {
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next())
				{
					article.setNo_article(rs.getInt(1));
				}
			    final String INSERT_ENCHERES="INSERT INTO ENCHERES(no_utilisateur, no_article, date_enchere, montant_enchere) "
			    	+ "VALUES ("+article.getNo_utilisateur()+", "+article.getNo_article()+", '"+article.getDate_debut_encheres()+"', "+article.getPrix_vente()+");";
			    
			    int j = stmt.executeUpdate(INSERT_ENCHERES);
			    if(j > 0) { vreturn = true; }
			}
			
		} catch(Exception e) {
			System.out.print(e.getMessage());
		}
		return vreturn;
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
