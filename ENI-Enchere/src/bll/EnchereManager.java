package bll;

import java.util.List;

import bo.Enchere;
import dal.DAOFactory;
import dal.EnchereDAO;

public class EnchereManager {
	private EnchereDAO enchereDAO;
	
	public EnchereManager() {
		this.enchereDAO = DAOFactory.getEnchereDAO();
	}
	
	public List<Enchere> selectAll() {
		return this.enchereDAO.selectAll();
	}
	
}
