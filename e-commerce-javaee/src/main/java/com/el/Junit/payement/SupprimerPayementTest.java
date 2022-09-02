package com.el.Junit.payement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.el.database.daofactory.DaoFactory;
import com.el.database.payements.PayementDao;
import com.el.exceptions.DaoException;

class SupprimerPayementTest {

	@Test
	void testSupprimerPayement() {
		DaoFactory daoFactory = DaoFactory.getInstance();
		PayementDao payementDao = daoFactory.getPayementDao();
		
		try {
			boolean test = payementDao.supprimerPayement(2);
			assertEquals(true, test);
		} catch (DaoException e) {
            System.out.println(e.getMessage());
		}
	}

}
