package bo;

import java.io.Serializable;
import java.sql.Date;

public class ArticleEnchere implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int no_article;
	private int no_categorie;
	private String nom_article;
	private float montant_enchere;
	private Date date_fin_encheres;
	private String pseudo;
	private String path_photo;
	
	public ArticleEnchere(int no_article, int no_categorie, String nom_article, float montant_enchere,
			Date date_fin_encheres, String pseudo, String path_photo) {
		super();
		this.no_article = no_article;
		this.no_categorie = no_categorie;
		this.nom_article = nom_article;
		this.montant_enchere = montant_enchere;
		this.date_fin_encheres = date_fin_encheres;
		this.pseudo = pseudo;
		this.path_photo = path_photo;
	}

	public int getNo_article() {
		return no_article;
	}

	public void setNo_article(int no_article) {
		this.no_article = no_article;
	}

	public int getNo_categorie() {
		return no_categorie;
	}

	public void setNo_categorie(int no_categorie) {
		this.no_categorie = no_categorie;
	}

	public String getNom_article() {
		return nom_article;
	}

	public void setNom_article(String nom_article) {
		this.nom_article = nom_article;
	}

	public float getMontant_enchere() {
		return montant_enchere;
	}

	public void setMontant_enchere(float montant_enchere) {
		this.montant_enchere = montant_enchere;
	}

	public Date getDate_fin_encheres() {
		return date_fin_encheres;
	}

	public void setDate_fin_encheres(Date date_fin_encheres) {
		this.date_fin_encheres = date_fin_encheres;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getPath_photo() {
		return path_photo;
	}

	public void setPath_photo(String path_photo) {
		this.path_photo = path_photo;
	}

	

	
	
	
}
