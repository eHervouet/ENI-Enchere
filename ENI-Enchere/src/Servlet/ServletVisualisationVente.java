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
		//int no_article = Integer.valueOf(no_article_String); 
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
