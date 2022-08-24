package com.el.Junit.client;

import org.junit.jupiter.api.Test;

import com.el.beans.Client;
import com.el.database.clients.ClientDao;
import com.el.database.daofactory.DaoFactory;
import com.el.exceptions.DaoException;

class ProfileClientTest {

	@Test
	void testProfileClient() {
		 try {
        	 DaoFactory daoFactory = DaoFactory.getInstance();
             ClientDao clientDao = daoFactory.getClientDao();
             Client client = clientDao.profileClient(1);
        	 System.out.println("Nom: "+client.getNom());
        	 System.out.println("prenom: "+client.getPrenom());
        	 System.out.println("email: "+client.getEmail());
		} catch (DaoException e) {
            e.getMessage();
		}
	}

}
