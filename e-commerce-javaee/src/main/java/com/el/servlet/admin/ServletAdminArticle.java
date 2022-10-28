package com.el.servlet.admin;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.el.beans.Article;
import com.el.beans.Categorie;
import com.el.beans.Image;
import com.el.database.articles.ArticleDao;
import com.el.database.categories.CategorieDao;
import com.el.database.daofactory.DaoFactory;
import com.el.database.images.ImageDao;
import com.el.exceptions.DaoException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

public class ServletAdminArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleDao articleDao; // pour acceder aux methodes de la classe implementant l'interface ArticleDao
	private CategorieDao categorieDao; // pour acceder aux methodes de la classe implementant l'interface CategorieDao
	private ImageDao imageDao;

	public ServletAdminArticle() {
		super();
	}

	// pour l'initialisation
	public void init() throws ServletException {
		DaoFactory daoFactory = DaoFactory.getInstance();
		this.articleDao = daoFactory.getArticleDao();
		this.categorieDao = daoFactory.getCategorieDao();
		this.imageDao = daoFactory.getImageDao();
	}

	// recuper tout les categories et articles , puis l'est envoient dans la jsp
	// adminArticle
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = (String) request.getParameter("operation");

		// si on ajoute un nouveau article
		if (operation.equals("post")) {
			String designation = (String) request.getParameter("designation");
			String detail = (String) request.getParameter("detail");
			int prixUnitaire = Integer.parseInt((String) request.getParameter("prixUnitaire"));
			int stock = Integer.parseInt((String) request.getParameter("stock"));
			int idCategorie = Integer.parseInt((String) request.getParameter("select-categorie"));

			try {
				Article article = new Article();
				article.setDesignation(designation);
				article.setDetail(detail);
				article.setPrixUnitaire(prixUnitaire);
				article.setStock(stock);
				article.setIdentifiantCategorie(idCategorie);
				boolean ajouterArticle = articleDao.ajouterArticleDansLaBase(article);
				request.setAttribute("ajoueReussie", ajouterArticle);
			} catch (DaoException e) {
				System.out.println(e.getMessage());
			}
		} else if (operation.equals("delete")) { // si on supprimer un article
			int idArticle = Integer.parseInt((String) request.getParameter("idArticleDelete"));
			Article article = new Article();
			article.setIdentifiant(idArticle);
			try {
				boolean supprimerArticle = articleDao.supprimerArticleDansLaBase(article);
				request.setAttribute("SuppressionReussie", supprimerArticle);
			} catch (DaoException e) {
				System.out.println(e.getMessage());
			}
		} else if (operation.equals("put")) { // si on met a jour un article
			int idArticle = Integer.parseInt((String) request.getParameter("idArticlePut"));
			String prixUnitaireString = (String) request.getParameter("prixUnitaire");
			String stockString = (String) request.getParameter("stock");
			Article article = new Article();
			article.setIdentifiant(idArticle);
			try {
				if (prixUnitaireString != "") {
					int prixUnitaire = Integer.parseInt(prixUnitaireString);
					boolean miseAjourPrixUnitaire = articleDao.mettreAjourPrixUnitaireArticle(article, prixUnitaire);
					request.setAttribute("miseAjourPrixUnitaire", miseAjourPrixUnitaire);
				}
				if (stockString != "") {
					int stock = Integer.parseInt(stockString);
					boolean miseAjourStock = articleDao.mettreAjourStockArticle(article, stock);
					request.setAttribute(" miseAjourStock", miseAjourStock);
				}
			} catch (DaoException e) {
				System.out.println(e.getMessage());
			}
		} else if (operation.equals("postImage")) { // si on ajoute une image a un article
			int idArticle = Integer.parseInt((String) request.getParameter("idArticleUploadFile"));
			final String CHEMIN_FICHIERS = getServletContext().getRealPath("/STOCKAGE/images_articles/"); // le chemin
																											// de
																											// stockage
																											// des
																											// images
			System.out.print("Mon url:");
			System.out.println(CHEMIN_FICHIERS);
			final int TAILLE_TAMPON = 10240;

			// On récupère le champ du fichier
			Part part = null;
			try {
				part = request.getPart("fichier");
			} catch (IOException | ServletException e) {
				e.printStackTrace();
			}

			Image image = new Image();
			image.setIdentifiantArticle(idArticle);

			// On vérifie qu'on a bien reçu un fichier
			String nomImage = image.getNomImage(part);
			image.setNom(nomImage);

			// Si on a bien un fichier
			if (nomImage != null && !nomImage.isEmpty()) {
				// On écrit définitivement le fichier sur le disque
				try {
					image.ecrireFichier(part, nomImage, CHEMIN_FICHIERS, TAILLE_TAMPON);
				} catch (IOException e) {
					e.printStackTrace();
				}

				try {
					imageDao.ajouterImage(image);
				} catch (DaoException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		
		// pour renvoyer a nouveau les articles
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

}
