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
				lae.add(new ArticleEnchere(
						rs.getInt("no_article"),
						rs.getString("nom_article"),
						rs.getDate("date_fin_encheres"),
						rs.getInt("no_categorie"),
						rs.getString("path_photo"),
						rs.getFloat("montant_enchere"),
						rs.getString("pseudo")
						));
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
            	articleEnchere = new ArticleEnchere(
						rs.getInt("no_article"),
						rs.getString("nom_article"),
						rs.getDate("date_fin_encheres"),
						rs.getInt("no_categorie"),
						rs.getString("path_photo"),
						rs.getFloat("montant_enchere"),
						rs.getString("pseudo")
						);
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
            	articleEnchere = new ArticleEnchere(
						rs.getInt("no_article"),
						rs.getString("nom_article"),
						rs.getDate("date_fin_encheres"),
						rs.getInt("no_categorie"),
						rs.getString("path_photo"),
						rs.getFloat("montant_enchere"),
						rs.getString("pseudo")
						);
            }
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return articleEnchere;
	}

	@Override
	public List<ArticleEnchere> getMesEncheres(int no_utilisateur) {
		final String SELECT = "select articles.no_article, articles.nom_article, articles.description, articles.date_debut_encheres, articles.date_fin_encheres, articles.prix_initial, articles.prix_vente, articles.no_utilisateur, articles.no_categorie, articles.path_photo, encheres.date_enchere, encheres.montant_enchere, utilisateurs.pseudo from articles, encheres, utilisateurs where articles.no_article = encheres.no_article and encheres.no_utilisateur = utilisateurs.no_utilisateur and encheres.no_utilisateur = "+no_utilisateur+";";
		List<ArticleEnchere> lae = new ArrayList<ArticleEnchere>();
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				lae.add(new ArticleEnchere(
						rs.getInt("no_article"),
						rs.getString("nom_article"),
						rs.getString("description"),
						rs.getDate("date_debut_encheres"),
						rs.getDate("date_fin_encheres"),
						rs.getInt("prix_initial"),
						rs.getInt("prix_vente"),
						rs.getInt("no_utilisateur"),
						rs.getInt("no_categorie"),
						rs.getString("path_photo"),
						rs.getDate("date_enchere"),
						rs.getFloat("montant_enchere"),
						rs.getString("pseudo")
						));
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return lae;
	}

}
