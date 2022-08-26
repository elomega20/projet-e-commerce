package com.el.Junit.categorie;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.el.beans.Categorie;
import com.el.database.categories.CategorieDao;
import com.el.database.daofactory.DaoFactory;
import com.el.exceptions.DaoException;

class SupprimerCategorieTest {

	@Test
	void testSupprimerCategorie() {
		 DaoFactory daoFactory = DaoFactory.getInstance();
	        CategorieDao categorieDao = daoFactory.getCategorieDao();
	        try {
				boolean test = categorieDao.supprimerCategorie(2);
				assertEquals(true, test);
			} catch (DaoException e) {
				e.getMessage();
			}
	}

}
