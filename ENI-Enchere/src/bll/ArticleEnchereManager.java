package bll;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import bo.ArticleEnchere;
import bo.Utilisateur;
import dal.ArticleEnchereDAO;
import dal.DAOFactory;

public class ArticleEnchereManager {
	
	private ArticleEnchereDAO articleEnchereDAO;
	
	public  ArticleEnchereManager() {
		this.articleEnchereDAO = DAOFactory.getArticleEnchereDAO();
	}	
	public List<ArticleEnchere> selectAll() {
		return this.articleEnchereDAO.selectAll();
		}
	
	public ArticleEnchere getArticleEnchereByNom(String nom_article) {
		return this.articleEnchereDAO.getArticleEnchereByNom(nom_article);
	}
	
	public ArticleEnchere getArticleEnchereById(int no_article) {
		return this.articleEnchereDAO.getArticleEnchereById(no_article);
	}
	public List<ArticleEnchere> getMesVentes(int no_utilisateur) {
		return this.articleEnchereDAO.getMesVentes(no_utilisateur);
	}
	public List<ArticleEnchere> getMesEncheres(int no_utilisateur) {
		return this.articleEnchereDAO.getMesEncheres(no_utilisateur);
	}
	public boolean updateArticleEnchere(ArticleEnchere articleEnchere, Date nouvelleDateEnchere, float montant_enchere) {
		return this.articleEnchereDAO.updateArticleEnchere(articleEnchere, nouvelleDateEnchere,montant_enchere);
	}
}

