package com.el.servlet.admin;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.el.beans.Article;
import com.el.beans.Categorie;
import com.el.database.articles.ArticleDao;
import com.el.database.categories.CategorieDao;
import com.el.database.daofactory.DaoFactory;
import com.el.exceptions.DaoException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ServletAdminArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleDao articleDao; //pour acceder aux methodes de la classe implementant l'interface ArticleDao 
	private CategorieDao categorieDao; //pour acceder aux methodes de la classe implementant l'interface CategorieDao 
       

    public ServletAdminArticle() {
        super();
    }
    
    // pour l'initialisation
    public void init() throws ServletException {
    	DaoFactory daoFactory = DaoFactory.getInstance();
		this.articleDao = daoFactory.getArticleDao();
		this.categorieDao = daoFactory.getCategorieDao();
	}

    //  recuper tout les categories et articles , puis l'est envoient dans la jsp adminArticle 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Categorie> categories = categorieDao.listerCategorie();
			Map<String, List<Article>> catalogues = articleDao.consulterCatalogue();
			request.setAttribute("categories", categories);
			request.setAttribute("catalogues", catalogues);

		} catch (DaoException e) {
            System.out.println(e.getMessage()); 
		} 
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/adminArticle.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = (String)request.getParameter("operation");
		// pour ajouter un nouveau article 
		if(operation.equals("post")) {
			String designation = (String)request.getParameter("designation");
			String detail = (String)request.getParameter("detail");
			int prixUnitaire = Integer.parseInt((String)request.getParameter("prixUnitaire"));
			int stock = Integer.parseInt((String)request.getParameter("stock"));
			int idCategorie = Integer.parseInt((String)request.getParameter("select-categorie"));
			
			try { 
				Article article = new Article();
				article.setDesignation(designation);
				article.setDetail(detail);
				article.setPrixUnitaire(prixUnitaire);
				article.setStock(stock);
				article.setIdentifiantCategorie(idCategorie);
				boolean ajoueReussie = articleDao.ajouterArticleDansLaBase(article);
				request.setAttribute("ajoueReussie", ajoueReussie);
			} catch (DaoException e) {
	            e.getMessage();
			}
		}else if(operation.equals("del")) { // pour supprimer un article
            String idArticleString = (String)request.getParameter("idArticle");
            int idArticle = Integer.parseInt(idArticleString);
            Article article = new Article();
            article.setIdentifiant(idArticle);
            try {
				boolean SuppressionReussie = articleDao.supprimerArticleDansLaBase(article);
				request.setAttribute("SuppressionReussie", SuppressionReussie);
			} catch (DaoException e) { 
				e.getMessage();
			}
		}
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/adminArticle.jsp").forward(request, response);
	}

}
