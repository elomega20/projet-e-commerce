package com.el.Junit.livreur;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.el.beans.Livreur;
import com.el.database.daofactory.DaoFactory;
import com.el.database.livreurs.LivreurDao;
import com.el.exceptions.DaoException;

class ListerLivreurTest {

	@Test
	void testListerLivreur() {
        DaoFactory  daoFactory = DaoFactory.getInstance();
        LivreurDao livreurDao = daoFactory.getLivreurDao();
        List<Livreur> livreurs = new ArrayList<Livreur>();
        try {
			livreurs = livreurDao.listerLivreur();
			for (Livreur livreur : livreurs) {
				System.out.println(livreur.getIdentifiant());
				System.out.println(livreur.getNomComplet());
				System.out.println(livreur.getNumeroTelephone());
				System.out.println(livreur.isDisponibilite());
				System.out.println();
			}
		} catch (DaoException e) {
            System.out.println(e.getMessage());
		}
	}

}
