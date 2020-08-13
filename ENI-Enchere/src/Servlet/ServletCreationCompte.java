package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.math.BigInteger; 
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
		String mot_de_passe_confirmation = (String) request.getParameter("mot_de_passe_confirmation");
		mot_de_passe = getMd5(mot_de_passe);
		String telephone = (String) request.getParameter("telephone");
		String rue = (String) request.getParameter("rue");
		
		UtilisateurManager um = new UtilisateurManager();
		Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, 0, false, false);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/creationCompte.jsp");
		
		if (!mot_de_passe.contentEquals(getMd5(mot_de_passe_confirmation))) {
			request.setAttribute("error", "Les deux mot de passe ne sont pas identiques.");
		} else if(!um.identifiantLibre(pseudo)) {
			request.setAttribute("error", "L'identifiant n'est pas disponible.");
		} else if (!um.emailLibre(email)) {
			request.setAttribute("error", "L'adresse mail indiquée est déjà attribuer à un compte.");
		} else if (!um.nouvelUtilisateur(utilisateur).getIsInBase()) {
			request.setAttribute("error", "Une erreur interne est survenue");
		} else {
			rd = request.getRequestDispatcher("/connexion");
		}
		
		rd.forward(request, response);
	}
	
	public static String getMd5(String input) 
    { 
        try { 
  
            // Static getInstance method is called with hashing MD5 
            MessageDigest md = MessageDigest.getInstance("MD5"); 
  
            // digest() method is called to calculate message digest 
            //  of an input digest() return array of byte 
            byte[] messageDigest = md.digest(input.getBytes()); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hex value 
            String hashtext = no.toString(16); 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
            return hashtext; 
        }  
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
    } 

}
