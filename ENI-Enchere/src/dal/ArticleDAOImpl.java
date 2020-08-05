package dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import bo.Article;

public class ArticleDAOImpl implements ArticleDAO {
	
	@Override
	public void nouvelArticle(Article article)
	{
		final String INSERT_ARTICLE="";
		
		System.out.print(INSERT_ARTICLE);
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(INSERT_ARTICLE);
			
		} catch(Exception e) {
			System.out.print(e.getMessage());
		}
	}
}
