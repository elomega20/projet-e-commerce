package com.el.Junit.article;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.el.beans.Article;
import com.el.beans.Categorie;
import com.el.database.articles.ArticleDao;
import com.el.database.daofactory.DaoFactory;
import com.el.exceptions.DaoException;

class RechercherArticleViaSonCategorietest {

	@Test
	void testRechercherArticleViaSonCategorie() {
		DaoFactory daoFactory = DaoFactory.getInstance();
		ArticleDao articleDao = daoFactory.getArticleDao();
		List<Article> articles;
		Categorie categorie = new Categorie();
		categorie.setIdentifiant(1);

		try {
			articles = articleDao.rechercherArticleViaSonCategorie(categorie);
			for (Article article : articles) {
				System.out.println(article.getIdentifiant());
				System.out.println(article.getDesignation());
				System.out.println(article.getDetail());
				System.out.println(article.getPrixUnitaire());
				System.out.println(article.getStock());
				System.out.println(article.getIdentifiantCategorie());
				System.out.println();
			}

		} catch (DaoException e) {
			System.out.println(e.getMessage());
		}
	}

}
