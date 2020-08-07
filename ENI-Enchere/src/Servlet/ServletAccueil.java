package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.ArticleEnchereManager;
import bll.ArticleManager;
import bll.CategorieManager;
import bll.UtilisateurManager;
import bo.Article;
import bo.ArticleEnchere;
import bo.Categorie;
import bo.Utilisateur;

/**
 * Servlet implementation class AccueilServlet
 */
@WebServlet("/accueil")
public class ServletAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategorieManager cm = new CategorieManager();
		List<Categorie> lc = cm.selectAll();
		
		ArticleEnchereManager aem = new ArticleEnchereManager();
		List<ArticleEnchere> lae = aem.selectAll();

		request.setAttribute("listeCategories", lc);
		request.setAttribute("listeArticleEncheres", lae);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
