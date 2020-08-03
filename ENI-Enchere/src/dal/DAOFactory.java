package dal;

public abstract class DAOFactory {
	
	public static CategorieDAO getCategorieDAO()
	{
		return new CategorieDAOImpl();
	}
}
