package com.el.Junit.categorie;

import org.junit.jupiter.api.Test;

import com.el.beans.Categorie;
import com.el.database.categories.CategorieDao;
import com.el.database.daofactory.DaoFactory;
import com.el.exceptions.DaoException;

class RechercherCategorieViaSonIdentifiantTest {

	@Test
	void testRechercherCategorieViaSonIdentifiant() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        CategorieDao categorieDao = daoFactory.getCategorieDao();
        
        try {
			Categorie categorie= categorieDao.rechercherCategorieViaSonIdentifiant(1);
			System.out.println(categorie.getIdentifiant());
			System.out.println(categorie.getNom());
		} catch (DaoException e) {
            System.out.println(e.getMessage());
		}
	}

}
