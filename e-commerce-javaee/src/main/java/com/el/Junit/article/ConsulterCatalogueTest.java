package com.el.Junit.article;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.el.beans.Article;
import com.el.beans.Categorie;
import com.el.database.articles.ArticleDao;
import com.el.database.categories.CategorieDao;
import com.el.database.daofactory.DaoFactory;
import com.el.exceptions.DaoException;

class ConsulterCatalogueTest {

	@Test
	void testConsulterCatalogue() {
		DaoFactory daoFactory = DaoFactory.getInstance();
		ArticleDao articleDao = daoFactory.getArticleDao();
		try {
			CategorieDao categorieDao = daoFactory.getCategorieDao();
			List<Categorie> categories = categorieDao.listerCategorie();
			Map<String, List<Article>> catalogues = articleDao.consulterCatalogue();
            for (Categorie categorie : categories) {
				System.out.println("------"+categorie.getNom()+"------");
				List<Article> articles = catalogues.get(categorie.getNom());
				for (Article article : articles) {
					System.out.println(article.getIdentifiant());
					System.out.println(article.getDesignation());
					System.out.println(article.getDetail());
					System.out.println(article.getPrixUnitaire());
					System.out.println(article.getStock());
					System.out.println(article.getIdentifiantCategorie());
					System.out.println();
				}
			}
		} catch (DaoException e) {
            System.out.println(e.getMessage());
		}
	}

}
