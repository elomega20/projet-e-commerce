package com.el.Junit.livreur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.el.beans.Livreur;
import com.el.database.daofactory.DaoFactory;
import com.el.database.livreurs.LivreurDao;

class SupprimerLivreurTest {

	@Test
	void testSupprimerLivreur() {
		DaoFactory daoFactory = DaoFactory.getInstance();
		LivreurDao livreurDao = daoFactory.getLivreurDao();
		Livreur livreur = new Livreur();
		livreur.setIdentifiant(4);
		livreur.setNomComplet("issa ba");
		livreur.setNumeroTelephone("776782315");
		livreur.setDisponibilite(true);
		try {
			boolean test = livreurDao.supprimerLivreur(livreur);
			assertEquals(true, test);
		} catch (Exception e) {
            System.out.println(e.getMessage());
		}
	}

}
