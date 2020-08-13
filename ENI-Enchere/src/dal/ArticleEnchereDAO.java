package dal;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import bo.ArticleEnchere;
import bo.Utilisateur;

public interface ArticleEnchereDAO {

	public List<ArticleEnchere> selectAll();
	
	public ArticleEnchere getArticleEnchereByNom(String nom_article);
	
	public ArticleEnchere getArticleEnchereById(int no_article);
	
	public List<ArticleEnchere> getMesVentes(int no_utilisateur);

	public List<ArticleEnchere> getMesEncheres(int no_utilisateur);
	
	public boolean updateArticleEnchere(ArticleEnchere articleEnchere, Date nouvelleDateEnchere, float montant_enchere);
}
