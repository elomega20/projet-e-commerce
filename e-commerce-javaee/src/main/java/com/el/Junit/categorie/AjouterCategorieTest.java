package com.el.Junit.categorie;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.el.beans.Categorie;
import com.el.database.categories.CategorieDao;
import com.el.database.daofactory.DaoFactory;
import com.el.exceptions.DaoException;

class AjouterCategorieTest {

	@Test
	void testAjouterCategorie() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        CategorieDao categorieDao = daoFactory.getCategorieDao();
        Categorie categorie = new Categorie();
        categorie.setNom("chaussures");
        try {
			boolean test = categorieDao.ajouterCategorie(categorie);
			assertEquals(true, test);
		} catch (DaoException e) {
			e.getMessage();
		}
	}

}
