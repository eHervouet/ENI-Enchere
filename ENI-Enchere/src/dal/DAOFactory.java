package dal;

public abstract class DAOFactory {
	
	public static CategorieDAO getCategorieDAO() {
		return new CategorieDAOImpl();
	}
	
	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOImpl();
	}
	
	public static EnchereDAO getEnchereDAO() {
		return new EnchereDAOImpl();
	}
	
	public static ArticleDAO getArticleDAO()
	{
		return new ArticleDAOImpl();
	}
	
	public static ArticleEnchereDAO getArticleEnchereDAO()
	{
		return new ArticleEnchereDAOImpl();
	}
}
