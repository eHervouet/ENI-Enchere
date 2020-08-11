package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bo.Article;
import bo.ArticleEnchere;
import bo.Categorie;

public class ArticleEnchereDAOImpl implements ArticleEnchereDAO {

	private static final String SELECT_ARTICLE_ENCHERE="SELECT  Articles.no_article, no_categorie, nom_article, montant_enchere, date_fin_encheres, pseudo, path_photo "
							+ "FROM Encheres"
							+ " inner join Articles on Encheres.no_article = Articles.no_article"  
							+ "	inner join  UTILISATEURS on UTILISATEURS.no_utilisateur = ENCHERES.no_utilisateur WHERE nom_article = ?;";
	
	
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

	@Override
	public ArticleEnchere getArticleEnchereByNom(String nom_article) {
		ArticleEnchere articleEnchere = null;
		try(Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ARTICLE_ENCHERE);
			pstmt.setString(1, nom_article);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
            	articleEnchere = new ArticleEnchere(rs.getInt("no_article"),
                                 rs.getInt("no_categorie"),
                                 rs.getString("nom_article"),
                                 rs.getFloat("montant_enchere"),
                                 rs.getDate("date_fin_encheres"),
                                 rs.getString("pseudo"),
                                 rs.getString("path_photo"));
            }
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return articleEnchere;
	}

	@Override
	public ArticleEnchere getArticleEnchereById(int no_article) {
		ArticleEnchere articleEnchere = null;
		try(Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ARTICLE_ENCHERE);
			pstmt.setInt(1, no_article);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
            	articleEnchere = new ArticleEnchere(rs.getInt("no_article"),
                                 rs.getInt("no_categorie"),
                                 rs.getString("nom_article"),
                                 rs.getFloat("montant_enchere"),
                                 rs.getDate("date_fin_encheres"),
                                 rs.getString("pseudo"),
                                 rs.getString("path_photo"));
            }
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return articleEnchere;
	}

}
