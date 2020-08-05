package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.UtilisateurManager;
import bo.Utilisateur;

/**
 * Servlet implementation class ServletCreationCompte
 */
@WebServlet("/creationCompte")
public class ServletCreationCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/creationCompte.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pseudo = (String) request.getParameter("pseudo");
		String prenom = (String) request.getParameter("prenom");
		String nom = (String) request.getParameter("nom");
		String email = (String) request.getParameter("email");
		String ville = (String) request.getParameter("ville");
		String code_postal = (String) request.getParameter("code_postal");
		String mot_de_passe = (String) request.getParameter("mot_de_passe");
		String telephone = (String) request.getParameter("telephone");
		String rue = (String) request.getParameter("rue");
		
		UtilisateurManager um = new UtilisateurManager();
		Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, 0, false);
		if(um.nouvelUtilisateur(utilisateur)) {
			RequestDispatcher rd = request.getRequestDispatcher("/connexion");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/creationCompte.jsp");
			rd.forward(request, response);
		}
	}

}
