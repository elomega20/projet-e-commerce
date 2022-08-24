package com.el.Junit.client;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.el.database.clients.ClientDao;
import com.el.database.daofactory.DaoFactory;
import com.el.exceptions.DaoException;

class SupprimerClientTest {

	@Test
	void testSupprimerClient() {
		try {
			DaoFactory daoFactory = DaoFactory.getInstance();
			ClientDao clientDao = daoFactory.getClientDao();
			boolean test = clientDao.supprimerClient(2);
			assertEquals(true, test);
		} catch (DaoException e) {
			e.getMessage();
		}
	}

}
