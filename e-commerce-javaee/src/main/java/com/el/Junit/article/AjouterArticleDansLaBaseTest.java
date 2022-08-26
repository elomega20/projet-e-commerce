package com.el.Junit.article;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.el.beans.Article;
import com.el.database.articles.ArticleDao;
import com.el.database.daofactory.DaoFactory;
import com.el.exceptions.DaoException;

class AjouterArticleDansLaBaseTest {

	@Test
	void testAjouterArticleDansLaBase() {
        Article article = new Article();
        article.setDesignation("Hp Imprimante Laser - HP 107a - Monochrome\r\n");
        article.setDetail("Bénéficiez de caractéristiques de productivité et de performance d'impression à un prix abordable et obtenez facilement des résultats de haute qualité.\r\n"
        		+ "Fonction de sécurité dynamique activée sur l’imprimante\r\n"
        		+ "Certaines imprimantes HP ont été conçues pour fonctionner uniquement avec des cartouches disposant d'une puce ou d'un circuit électronique HP neuf ou réutilisé. Ces imprimantes sont équipées d’un dispositif de sécurité dynamique pour bloquer les cartouches utilisant une puce ou un circuit électronique non-HP. Les mises à jour périodiques du micrologiciel permettent d’assurer l'efficacité de ces mesures et bloquent les cartouches qui fonctionnaient auparavant. Les puces et circuits électroniques HP réutilisés permettent d'utiliser des cartouches réutilisées, reconditionnées ou recyclées.");
        article.setPrixUnitaire(145000);
        article.setStock(20);
        article.setIdentifiantCategorie(1);
        
        try {
			DaoFactory daoFactory = DaoFactory.getInstance();
			ArticleDao articleDao = daoFactory.getArticleDao();
			boolean test = articleDao.ajouterArticleDansLaBase(article);
			assertEquals(true, test);
		} catch (DaoException e) {
            System.out.println(e.getMessage());
		}
	}

}
