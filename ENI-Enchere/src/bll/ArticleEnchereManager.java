package bll;

import java.util.List;

import bo.ArticleEnchere;
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
}

