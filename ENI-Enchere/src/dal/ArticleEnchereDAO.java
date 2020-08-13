package dal;

import java.util.List;

import bo.ArticleEnchere;

public interface ArticleEnchereDAO {

	public List<ArticleEnchere> selectAll();
	
	public ArticleEnchere getArticleEnchereByNom(String nom_article);
	
	public ArticleEnchere getArticleEnchereById(int no_article);
	
	public List<ArticleEnchere> getMesVentes(int no_utilisateur);

	public List<ArticleEnchere> getMesEncheres(int no_utilisateur);
}
