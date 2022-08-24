package com.el.Junit.client;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.el.beans.Client;
import com.el.database.clients.ClientDao;
import com.el.database.daofactory.DaoFactory;
import com.el.exceptions.DaoException;

class ListerClientTest {

	@Test
	void testListerClient() {
        List<Client> clients = new ArrayList<Client>();
        try {
        	 DaoFactory daoFactory = DaoFactory.getInstance();
             ClientDao clientDao = daoFactory.getClientDao();
             clients = clientDao.listerClient();
             for(Client client: clients) {
            	 System.out.println("id: "+client.getIdentifiant());
            	 System.out.println("email: "+client.getEmail());
            	 System.out.println("MotDePass: "+client.getMotDePass());
            	 System.out.println("Nom: "+client.getNom());
            	 System.out.println("prenom: "+client.getPrenom());
            	 System.out.println();
             }
		} catch (DaoException e) {
            e.getMessage();
		}
	}

}
