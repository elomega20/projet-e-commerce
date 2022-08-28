package com.el.Junit.article;

import org.junit.jupiter.api.Test;

import com.el.beans.Article;
import com.el.database.articles.ArticleDao;
import com.el.database.daofactory.DaoFactory;
import com.el.exceptions.DaoException;

class RechercherArticleViaSonIdentifiantTest {

	@Test
	void testRechercherArticleViaSonIdentifiant() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        ArticleDao articleDao = daoFactory.getArticleDao();
        Article article;
        
        try {
			article = articleDao.rechercherArticleViaSonIdentifiant(2);
			System.out.println(article.getIdentifiant());
			System.out.println(article.getDesignation());
			System.out.println(article.getDetail());
			System.out.println(article.getPrixUnitaire());
			System.out.println(article.getStock());
			System.out.println(article.getIdentifiantCategorie());
		} catch (DaoException e) {
            System.out.println(e.getMessage());
		}
	}

}
