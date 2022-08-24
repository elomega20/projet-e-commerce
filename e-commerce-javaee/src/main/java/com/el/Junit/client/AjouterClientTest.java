package com.el.Junit.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.el.beans.Client;
import com.el.database.clients.ClientDao;
import com.el.database.daofactory.DaoFactory;
import com.el.exceptions.DaoException;

class AjouterClientTest {

	@Test
	void testAjouterClient() {
        Client client = new Client();
        client.setEmail("moussa@gmail.com");
        client.setMotDePass("moussa123");
        client.setNom("Ba");
        client.setPrenom("moussa");
        try {
        	 DaoFactory daoFactory = DaoFactory.getInstance();
             ClientDao clientDao = daoFactory.getClientDao();
             boolean test = clientDao.ajouterClient(client);
             assertEquals(true, test);
		} catch (DaoException e) {
            e.getMessage();
		}
	}

}
