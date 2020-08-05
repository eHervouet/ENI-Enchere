package bll;

import bo.Article;
import bo.Utilisateur;
import dal.DAOFactory;
import dal.UtilisateurDAO;
import dal.ArticleDAO;

public class ArticleManager {

	private ArticleDAO articleDAO;
	
	public ArticleManager() {
		this.articleDAO = DAOFactory.getArticleDAO();
	}
	
	public void nouvelArticle(Article article) {
		this.articleDAO.nouvelArticle(article);
	}
}
