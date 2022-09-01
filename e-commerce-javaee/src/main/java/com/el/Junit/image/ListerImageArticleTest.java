package com.el.Junit.image;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.el.beans.Article;
import com.el.beans.Image;
import com.el.database.articles.ArticleDao;
import com.el.database.daofactory.DaoFactory;
import com.el.database.images.ImageDao;
import com.el.exceptions.DaoException;

class ListerImageArticleTest {

	@Test
	void testLiserImageArticle() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        ImageDao imageDao = daoFactory.getImageDao();
        ArticleDao articleDao = daoFactory.getArticleDao();
        Article article;
        List<Image> images;
        try {
			article = articleDao.rechercherArticleViaSonIdentifiant(2);
			images = imageDao.liserImageArticle(article);
			for (Image image : images) {
				System.out.println(image.getIdentifiant());
				System.out.println(image.getNom());
				System.out.println(image.getIdentifiantArticle());
				System.out.println();
			}
		} catch (DaoException e) {
            e.getMessage();
		}
	}

}
