package com.el.Junit.client;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.el.beans.Client;
import com.el.database.clients.ClientDao;
import com.el.database.daofactory.DaoFactory;
import com.el.exceptions.DaoException;

class ModifierMotDePassTest {

	@Test
	void testModifierMotDePass() {
		Client client = new Client();
		client.setEmail("moussa@gmail.com");
		client.setMotDePass("moussa123");
		client.setNom("Ba");
		client.setPrenom("moussa");
		client.setIdentifiant(1);

		try {
			DaoFactory daoFactory = DaoFactory.getInstance();
			ClientDao clientDao = daoFactory.getClientDao();
			boolean test = clientDao.modifierMotDePass(client, "moussamdp123");
			assertEquals(true, test);
		} catch (DaoException e) {
			e.getMessage();
		}
	}

}
