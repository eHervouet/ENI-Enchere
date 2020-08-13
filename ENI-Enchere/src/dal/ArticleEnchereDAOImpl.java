package dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import bo.Article;
import bo.ArticleEnchere;
import bo.Categorie;

public class ArticleEnchereDAOImpl implements ArticleEnchereDAO {
	
	
	@Override
	public List<ArticleEnchere> selectAll() {
		final String SELECT="SELECT date_enchere, Articles.no_article, no_categorie, nom_article, montant_enchere, date_fin_encheres, pseudo, path_photo "
				+ "FROM Encheres"
				+ " inner join Articles on Encheres.no_article = Articles.no_article"
				+ "	inner join  UTILISATEURS on UTILISATEURS.no_utilisateur = ARTICLES.no_utilisateur;";
		
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
		final String SELECT="SELECT   Articles.no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, UTILISATEURS.no_utilisateur, ARTICLES.no_categorie, nom_article, date_enchere, montant_enchere, pseudo, path_photo, libelle " 
				+ " FROM Encheres "
				+ " inner join Articles on Encheres.no_article = Articles.no_article " 
				+ " inner join UTILISATEURS on UTILISATEURS.no_utilisateur = ENCHERES.no_utilisateur "
				+ " inner join CATEGORIES on ARTICLES.no_categorie = CATEGORIES.no_categorie "
				+ " WHERE Articles.nom_article = "+nom_article+";";
		ArticleEnchere articleEnchere = null;
		try(Connection cnx = ConnectionProvider.getConnection()){
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT);
			while(rs.next())
            {
            	articleEnchere = new ArticleEnchere(
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
						rs.getString("pseudo"),
						rs.getString("libelle")
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
		final String SELECT="SELECT   Articles.no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, UTILISATEURS.no_utilisateur, ARTICLES.no_categorie, nom_article, date_enchere, montant_enchere, pseudo, path_photo, libelle " 
						+ " FROM Encheres "
						+ " inner join Articles on Encheres.no_article = Articles.no_article " 
						+ " inner join UTILISATEURS on UTILISATEURS.no_utilisateur = ENCHERES.no_utilisateur "
						+ " inner join CATEGORIES on ARTICLES.no_categorie = CATEGORIES.no_categorie "
						+ " WHERE Articles.no_article = "+no_article+";";
		ArticleEnchere articleEnchere = null;
		try(Connection cnx = ConnectionProvider.getConnection()){
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT);
            while(rs.next())
            {
            	articleEnchere = new ArticleEnchere(
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
						rs.getString("pseudo"),
						rs.getString("libelle")
						);
            }
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return articleEnchere;
	}
		

	@Override
	public List<ArticleEnchere> getMesVentes(int no_utilisateur) {
		final String SELECT = "select articles.no_article, articles.nom_article, articles.description, articles.date_debut_encheres, articles.date_fin_encheres, articles.prix_initial, articles.prix_vente, articles.no_utilisateur, articles.no_categorie, articles.path_photo, encheres.date_enchere, encheres.montant_enchere, utilisateurs.pseudo from articles, encheres, utilisateurs where articles.no_article = encheres.no_article and encheres.no_utilisateur = utilisateurs.no_utilisateur and articles.no_utilisateur = "+no_utilisateur+";";
		List<ArticleEnchere> laev = new ArrayList<ArticleEnchere>();
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				laev.add(new ArticleEnchere(
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
		
		return laev;
	}

	
	public List<ArticleEnchere> getMesEncheres(int no_utilisateur) {
		final String SELECT = "select articles.no_article, articles.nom_article, articles.description, articles.date_debut_encheres, articles.date_fin_encheres, articles.prix_initial, articles.prix_vente, articles.no_utilisateur, articles.no_categorie, articles.path_photo, encheres.date_enchere, encheres.montant_enchere, utilisateurs.pseudo from articles, encheres, utilisateurs where articles.no_article = encheres.no_article and encheres.no_utilisateur = UTILISATEURS.no_utilisateur and encheres.no_utilisateur = "+no_utilisateur+";";
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

	@Override
	public boolean updateArticleEnchere(ArticleEnchere articleEnchere, Date nouvelleDateEnchere, float montant_enchere) {
		final String UPDATE = "UPDATE ENCHERES SET ENCHERES.date_enchere = '"+nouvelleDateEnchere+"', ENCHERES.montant_enchere = "+montant_enchere
				+ " FROM ENCHERES "
				+ "WHERE ENCHERES.no_article = "+articleEnchere.getNo_article()+";";
		boolean ok = false;
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			Statement stmt = cnx.createStatement();
			int rs = stmt.executeUpdate(UPDATE);
			if(rs >0) {
				ok = true; 
				return ok;
			}
			
		} catch(Exception e) {
			System.out.print(e.getMessage());
		}
		return ok;
	
	}
}
