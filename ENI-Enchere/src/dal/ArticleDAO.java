package dal;

import java.util.List;

import bo.Article;
import bo.Enchere;

public interface ArticleDAO {
	public void nouvelArticle(Article article);
	public Article getArticleById(int no_article);
	public List<Article> selectAll();
	
}
