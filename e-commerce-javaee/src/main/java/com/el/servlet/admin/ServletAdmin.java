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


public class ServletAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleDao articleDao;
	private CategorieDao categorieDao;
       

    public ServletAdmin() {
        super();
    }
    
    public void init() throws ServletException {
    	DaoFactory daoFactory = DaoFactory.getInstance();
		this.articleDao = daoFactory.getArticleDao();
		this.categorieDao = daoFactory.getCategorieDao();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Categorie> categories = categorieDao.listerCategorie();
			Map<String, List<Article>> catalogues = articleDao.consulterCatalogue();
			request.setAttribute("categories", categories);
			request.setAttribute("catalogues", catalogues);

		} catch (DaoException e) {
            System.out.println(e.getMessage()); 
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/admin.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
