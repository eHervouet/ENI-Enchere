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
 * Servlet implementation class ServletModifierProfil
 */
@WebServlet("/modifierProfil")
public class ServletModifierProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no_utilisateur = request.getParameter("no_utilisateur");
		String pseudo = (String) request.getParameter("pseudo");
		String prenom = (String) request.getParameter("prenom");
		String nom = (String) request.getParameter("nom");
		String email = (String) request.getParameter("email");
		String ville = (String) request.getParameter("ville");
		String code_postal = (String) request.getParameter("code_postal");
		String telephone = (String) request.getParameter("telephone");
		String rue = (String) request.getParameter("rue");
		
		UtilisateurManager um = new UtilisateurManager();
		Utilisateur utilisateur = new Utilisateur(Integer.valueOf(no_utilisateur), pseudo, nom, prenom, email, telephone, rue, code_postal, ville, null, 0, false, false);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/profil.jsp");
		
		if(!um.identifiantLibre(pseudo)) {
			request.setAttribute("error", "L'identifiant n'est pas disponible.");
		} else if (!um.emailLibre(email)) {
			request.setAttribute("error", "L'adresse mail indiquée est déjà attribuer à un compte.");
		} else if (!um.modifierUtilisateur(utilisateur).getIsInBase()) {
			request.setAttribute("error", "Une erreur interne est survenue");
		}
		
		HttpSession session = request.getSession();
		session.removeAttribute("utilisateur");
		Utilisateur utilisateurSess = um.getUtilisateurByIdentifiant(pseudo);
		session.setAttribute("utilisateur", utilisateurSess);
		
		rd.forward(request, response);
	}

}
