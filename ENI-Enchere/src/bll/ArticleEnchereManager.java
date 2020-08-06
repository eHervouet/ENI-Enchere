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
}

