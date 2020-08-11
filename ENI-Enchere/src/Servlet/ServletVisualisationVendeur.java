package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.ArticleManager;
import bll.UtilisateurManager;
import bo.Article;
import bo.Utilisateur;

/**
 * Servlet implementation class ServletVisualisationVendeur
 */
@WebServlet("/voirVendeur")
public class ServletVisualisationVendeur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pseudo = request.getParameter("pseudo");
		UtilisateurManager um = new UtilisateurManager();
		ArticleManager am = new ArticleManager();
		
		Utilisateur utilisateur = um.getUtilisateurByIdentifiant(pseudo);
		request.setAttribute("utilisateur", utilisateur);
		
		List<Article> la = am.selectArticleByUtilisateur(utilisateur.getNo_utilisateur());
		for(Article a : la) {
			System.out.print(a.getNom_article());
		}
		request.setAttribute("la", la);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/voirVendeur.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
