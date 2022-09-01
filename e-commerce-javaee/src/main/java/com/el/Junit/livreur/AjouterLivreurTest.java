package com.el.Junit.livreur;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.el.beans.Livreur;
import com.el.database.daofactory.DaoFactory;
import com.el.database.livreurs.LivreurDao;
import com.el.exceptions.DaoException;

class AjouterLivreurTest {

	@Test
	void testAjouterLivreur() {
		DaoFactory daoFactory = DaoFactory.getInstance();
		LivreurDao livreurDao = daoFactory.getLivreurDao();
		Livreur livreur = new Livreur();
		livreur.setNomComplet("abdou diallo");
		livreur.setNumeroTelephone("750101232");
		livreur.setDisponibilite(false);
		boolean test;
		try {
			test = livreurDao.ajouterLivreur(livreur);
			assertEquals(true, test);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
		}
	}

}
