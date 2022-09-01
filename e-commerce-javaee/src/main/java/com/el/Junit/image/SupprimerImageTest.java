package com.el.Junit.image;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.el.database.daofactory.DaoFactory;
import com.el.database.images.ImageDao;
import com.el.exceptions.DaoException;

class SupprimerImageTest {

	@Test
	void testSupprimerImage() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        ImageDao imageDao = daoFactory.getImageDao();
        try {
			boolean test = imageDao.supprimerImage(1);
			assertEquals(true, test);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
		}
	}

}
