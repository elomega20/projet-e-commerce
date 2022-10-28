package com.el.servlet.images;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ServletAjouterImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ServletAjouterImage() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/vue-ajouter-image.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*String cheminAbsolue = getServletContext().getRealPath("/STOCKAGE/images/"); 
		Image image = new Image();
		DaoFactory daoFactory = DaoFactory.getInstance();
		ImageDao imageDao = daoFactory.getImageDao();
		image.setIdentifiantArticle(2);
		try {
			imageDao.ajouterImage(request, image, cheminAbsolue);
		} catch (DaoException e) {
            e.getMessage();
		}*/
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/vue-ajouter-image.jsp").forward(request, response);
	}

}
