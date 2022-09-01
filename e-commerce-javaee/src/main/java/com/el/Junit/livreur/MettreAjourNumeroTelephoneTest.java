package com.el.Junit.livreur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.el.beans.Livreur;
import com.el.database.daofactory.DaoFactory;
import com.el.database.livreurs.LivreurDao;

class MettreAjourNumeroTelephoneTest {

	@Test
	void testMettreAjourNumeroTelephone() {
		DaoFactory daoFactory = DaoFactory.getInstance();
		LivreurDao livreurDao = daoFactory.getLivreurDao();
		Livreur livreur = new Livreur();
		livreur.setIdentifiant(3);
		try {
			boolean test = livreurDao.mettreAjourNumeroTelephone(livreur,"777777777");
			assertEquals(true, test);
		} catch (Exception e) {
            System.out.println(e.getMessage());
		}
	}

}
