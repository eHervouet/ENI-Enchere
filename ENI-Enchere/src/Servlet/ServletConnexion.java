package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bll.UtilisateurManager;
import bo.Utilisateur;

/**
 * Servlet implementation class ServletConnexion
 */
@WebServlet("/connexion")
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp");
		rd.forward(request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String identifiant = (String) request.getParameter("identifiant");
		String mot_de_passe = (String) request.getParameter("mot_de_passe");
		
		UtilisateurManager um = new UtilisateurManager();
		boolean con = um.connexion(identifiant, mot_de_passe);
		if (!con) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp");
			request.setAttribute("err", "L'identifiant ou le mot de passe est incorrect.");
			rd.forward(request, response);
		} else {
			HttpSession session = request.getSession();
			Utilisateur utilisateur = um.getUtilisateurByIdentifiant(identifiant);
			session.setAttribute("utilisateur", utilisateur);
			//RequestDispatcher rd = request.getRequestDispatcher("/accueil");
			//rd.forward(request, response);
			response.sendRedirect("/ENI-Enchere/accueil");
		}
				
	}

}
