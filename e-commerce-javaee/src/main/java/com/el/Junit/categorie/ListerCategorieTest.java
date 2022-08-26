package com.el.Junit.categorie;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.el.beans.Categorie;
import com.el.database.categories.CategorieDao;
import com.el.database.daofactory.DaoFactory;
import com.el.exceptions.DaoException;

class ListerCategorieTest {

	@Test
	void testListerCategorie() {
		DaoFactory daoFactory = DaoFactory.getInstance();
		CategorieDao categorieDao = daoFactory.getCategorieDao();
		List<Categorie> categories = new ArrayList<Categorie>();

		try {
			categories = categorieDao.listerCategorie();
			for (Categorie categorie : categories) {
				System.out.println(categorie.getIdentifiant());
				System.out.println(categorie.getNom());
			}
		} catch (DaoException e) {
			System.out.println(e.getMessage()); 
		}
	}

}
