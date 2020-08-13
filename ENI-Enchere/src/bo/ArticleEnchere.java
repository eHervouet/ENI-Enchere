package bo;

import java.io.Serializable;
import java.sql.Date;

public class ArticleEnchere implements Serializable {
	
	private static final long serialVersionUID = 1L;
	//table article
	private int no_article;
	private String nom_article;
	private String description;
	private Date date_debut_encheres;
	private Date date_fin_encheres;
	private int prix_initial;
	private int prix_vente;
	private int no_utilisateur;
	private int no_categorie;
	private String path_photo;
	//table enchère
	private Date date_enchere;
	private float montant_enchere;
	//table utilisateur
	private String pseudo;
	//table catégorie
	private String libelle;
	
	public ArticleEnchere(int no_article, String nom_article, String description, Date date_debut_encheres,
			Date date_fin_encheres, int prix_initial, int prix_vente, int no_utilisateur, int no_categorie,
			String path_photo, Date date_enchere, float montant_enchere, String pseudo) {
		super();
		this.no_article = no_article;
		this.nom_article = nom_article;
		this.description = description;
		this.date_debut_encheres = date_debut_encheres;
		this.date_fin_encheres = date_fin_encheres;
		this.prix_initial = prix_initial;
		this.prix_vente = prix_vente;
		this.no_utilisateur = no_utilisateur;
		this.no_categorie = no_categorie;
		this.path_photo = path_photo;
		this.date_enchere = date_enchere;
		this.montant_enchere = montant_enchere;
		this.pseudo = pseudo;
	}
	
	public ArticleEnchere(int no_article, String nom_article, String description, Date date_debut_encheres,
			Date date_fin_encheres, int prix_initial, int prix_vente, int no_utilisateur, int no_categorie,
			String path_photo, Date date_enchere, float montant_enchere, String pseudo, String libelle) {
		super();
		this.no_article = no_article;
		this.nom_article = nom_article;
		this.description = description;
		this.date_debut_encheres = date_debut_encheres;
		this.date_fin_encheres = date_fin_encheres;
		this.prix_initial = prix_initial;
		this.prix_vente = prix_vente;
		this.no_utilisateur = no_utilisateur;
		this.no_categorie = no_categorie;
		this.path_photo = path_photo;
		this.date_enchere = date_enchere;
		this.montant_enchere = montant_enchere;
		this.pseudo = pseudo;
		this.libelle = libelle;
	}
	
	public ArticleEnchere(int no_article, String nom_article, Date date_fin_encheres, int no_categorie, String path_photo, float montant_enchere, String pseudo) {
		this.no_article = no_article;
		this.nom_article = nom_article;
		this.date_fin_encheres = date_fin_encheres;
		this.no_categorie = no_categorie;
		this.path_photo = path_photo;
		this.montant_enchere = montant_enchere;
		this.pseudo = pseudo;
	}

	public int getNo_article() {
		return no_article;
	}
	public void setNo_article(int no_article) {
		this.no_article = no_article;
	}
	public String getNom_article() {
		return nom_article;
	}
	public void setNom_article(String nom_article) {
		this.nom_article = nom_article;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate_debut_encheres() {
		return date_debut_encheres;
	}
	public void setDate_debut_encheres(Date date_debut_encheres) {
		this.date_debut_encheres = date_debut_encheres;
	}
	public Date getDate_fin_encheres() {
		return date_fin_encheres;
	}
	public void setDate_fin_encheres(Date date_fin_encheres) {
		this.date_fin_encheres = date_fin_encheres;
	}
	public int getPrix_initial() {
		return prix_initial;
	}
	public void setPrix_initial(int prix_initial) {
		this.prix_initial = prix_initial;
	}
	public int getPrix_vente() {
		return prix_vente;
	}
	public void setPrix_vente(int prix_vente) {
		this.prix_vente = prix_vente;
	}
	public int getNo_utilisateur() {
		return no_utilisateur;
	}
	public void setNo_utilisateur(int no_utilisateur) {
		this.no_utilisateur = no_utilisateur;
	}
	public int getNo_categorie() {
		return no_categorie;
	}
	public void setNo_categorie(int no_categorie) {
		this.no_categorie = no_categorie;
	}
	public String getPath_photo() {
		return path_photo;
	}
	public void setPath_photo(String path_photo) {
		this.path_photo = path_photo;
	}
	public Date getDate_enchere() {
		return date_enchere;
	}
	public void setDate_enchere(Date date_enchere) {
		this.date_enchere = date_enchere;
	}
	public float getMontant_enchere() {
		return montant_enchere;
	}
	public void setMontant_enchere(float montant_enchere) {
		this.montant_enchere = montant_enchere;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
}
