package dal;
import bo.Article;
import bo.Enchere;
import java.util.List;

public interface EnchereDAO {
	public List<Enchere> selectAll();
	
	public boolean ajouterEnchere(Enchere ench);
}
