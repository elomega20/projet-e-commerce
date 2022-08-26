package com.el.Junit.article;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.el.beans.Article;
import com.el.database.articles.ArticleDao;
import com.el.database.daofactory.DaoFactory;
import com.el.exceptions.DaoException;

class MettreAjourPrixUnitaireArticleTest {

	@Test
	void testMettreAjourPrixUnitaireArticle() {
		Article article = new Article();
		article.setIdentifiant(1);
		article.setDesignation("Fashion Baskets Décontractées pour Homme - Gris");
		article.setDetail("Cette paire en plus d'être confortable est très élégante. \r\n"
				+ "Un must have pour l'homme classique. Nous avons les meilleurs prix et services. Ces chaussures sont plus pratiques à porter, montrant une texture de ligne uniforme et lisse, simple et généreuse.Semelle extérieure en  léger: avec une semelle souple et rembourrée pour un style élégant, stylé et simple. Conception de texture claire, adhérence forte, antidérapante, résistante à l'usure. \r\n"
				+ "La semelle extérieure en si durable offre une adhérence sur une variété de surfaces. Tissu confortable et délicat: respire le lustre naturel, souligne la qualité et montre le style décontracté des hommes. \r\n"
				+ "Doublure confortable: selon l'ergonomie, la partie intérieure est faite d'un matériau respirant et ajusté au pied, de sorte que vos pieds puissent continuer à respirer en douceur et facilement répondre aux besoins de la vie.Simple et à la mode, doux et confortable, léger et résistant à l'usure ，il est parfait pour un usage quotidien.Ces chaussures classiques à boucle simple moine sont dotées d'une tige en cuir, d'un design à enfiler pour un port facile et des chaussures moine sur le côté pour plus de style. De plus, il est fini avec une doublure en cuir lisse, une assise plantaire coussinée pour plus de confort et une semelle extérieure antidérapante. Ce type de chaussures que vous portez avec un jean ou un pantalon collocation, vous fait refléter le tempérament difficile! Doté de semelles durables qui permettent une traction facile, il est également très confortable. \r\n"
				+ "Un match parfait avec des tenues semi-décontractées et officielles.Si vous n'êtes pas satisfait de quelque chose, veuillez nous contacter avant de nous laisser un commentaire négatif. Nous ferons toujours de notre mieux pour 100% de satisfaction client.\r\n"
				+ "C'est pourquoi nous sommes ici! Tous les e-mails recevront une réponse dans les 48 heures (samedi et dimanche exclus). Alors n'hésitez pas à nous envoyer un email! La pointure de cette chaussure est un peu trop petite, merci d'acheter une pointure plus grande que les chaussures habituelles.");
		article.setPrixUnitaire(5900);
		article.setStock(10);
		article.setIdentifiantCategorie(4);
		try {
			DaoFactory daoFactory = DaoFactory.getInstance();
			ArticleDao articleDao = daoFactory.getArticleDao();
			boolean test = articleDao.mettreAjourPrixUnitaireArticle(article,8000);
			assertEquals(true, test);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
		}
	}

}
