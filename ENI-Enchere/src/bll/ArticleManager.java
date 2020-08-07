package bll;

import java.util.List;

import bo.Article;
import bo.Categorie;
import bo.Utilisateur;
import dal.DAOFactory;
import dal.UtilisateurDAO;
import dal.ArticleDAO;

public class ArticleManager {

	private ArticleDAO articleDAO;
	
	public ArticleManager() {
		this.articleDAO = DAOFactory.getArticleDAO();
	}
	
	//retourne l'id de l'article crée
	public boolean nouvelArticle(Article article) {
		return this.articleDAO.nouvelArticle(article);
	}
	
	public Article getArticleById(int no_article) {
		return this.articleDAO.getArticleById(no_article);
	}
	
	public List<Article> selectAll() {
		return this.articleDAO.selectAll();
	}
	
}
