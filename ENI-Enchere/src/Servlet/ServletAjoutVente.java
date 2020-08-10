package Servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Calendar;
import java.util.List;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import bll.ArticleManager;
import bll.CategorieManager;
import bo.Article;
import bo.Categorie;
import bo.Utilisateur;


/**
 * Servlet implementation class ServletAjoutVente
 */
@WebServlet("/ajoutVente")
@MultipartConfig
public class ServletAjoutVente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategorieManager cm = new CategorieManager();
		List<Categorie> lc = cm.selectAll();
		
		request.setAttribute("listeCategories", lc);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/ajoutVente.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom_article = (String) request.getParameter("article");
		String description = (String) request.getParameter("description");
		Date date_debut_encheres = Date.valueOf(request.getParameter("date_deb"));
		Date date_fin_encheres = Date.valueOf(request.getParameter("date_fin"));
		int prix_initial = Integer.parseInt(request.getParameter("prix"));
		int prix_vente = Integer.parseInt(request.getParameter("prix"));
		int no_categorie = Integer.parseInt(request.getParameter("categories"));
		String rue = (String) request.getParameter("rue");
		String ville = (String) request.getParameter("ville");
		String cp = (String) request.getParameter("cp");
		
		//récupération de l'id client en cours
		HttpSession session = request.getSession();
		Utilisateur user = (Utilisateur)session.getAttribute("utilisateur");
		int no_utilisateur = user.getNo_utilisateur();
		
		//get the file chosen by the user
		Part uploadedFile = request.getPart("photoAUploader"); //path webapps tomcat
		String time = String.valueOf(Calendar.getInstance().getTimeInMillis());
		String fileName = uploadedFile.getSubmittedFileName();
		fileName = time + fileName.substring(fileName.lastIndexOf("."));
		
		Path folder = Paths.get( getServletContext().getRealPath("/")+"\\photos_articles\\"+fileName);
				
		//get the InputStream to store the file somewhere
		try (InputStream fileInputStream = uploadedFile.getInputStream()) {
		    Files.copy(fileInputStream, folder, StandardCopyOption.REPLACE_EXISTING);
		}
		
		ArticleManager am = new ArticleManager();
		Article art = new Article(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, 
				prix_vente, no_utilisateur, no_categorie, fileName);
		
		try{
			am.nouvelArticle(art);
			
		}catch(Exception e)
		{
			System.out.println("Un probl�me est survenu lors de la cr�ation de l'article " + e);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/accueil");
		rd.forward(request, response);
	}

}
