package Servlet;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.ArticleEnchereManager;
import bo.ArticleEnchere;

/**
 * Servlet implementation class ServletVisualisationVente
 */
@WebServlet("/detailVente")
public class ServletVisualisationVente extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no_article = Integer.valueOf(request.getParameter("no_article"));
		ArticleEnchereManager aem = new ArticleEnchereManager();
		ArticleEnchere articleEnchere = aem.getArticleEnchereById(no_article);
		request.setAttribute("articleEnchere", articleEnchere);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/detailVente.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArticleEnchereManager aem = new ArticleEnchereManager();
		float montant_enchere = Float.parseFloat(request.getParameter("proposition"));
		int no_article = Integer.valueOf(request.getParameter("noarticle"));
		ArticleEnchere articleEnchere= aem.getArticleEnchereById(no_article);
		request.setAttribute("articleEnchere", articleEnchere);
		LocalDate localDate = LocalDate.now();
		Date date = java.sql.Date.valueOf(localDate);
		boolean upd = aem.updateArticleEnchere(articleEnchere, date ,montant_enchere);
		
		//System.out.println("montant de l'enchere : "+montant_enchere);
		//System.out.println("no_article : "+no_article);
		//System.out.println("date : "+date);
		//System.out.println("update : "+upd);
		
		response.sendRedirect("/ENI-Enchere/detailVente?no_article="+articleEnchere.getNo_article());
	}

}
