package com.el.Junit.commande;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.el.beans.Client;
import com.el.database.commandes.CommandeDao;
import com.el.database.daofactory.DaoFactory;
import com.el.exceptions.DaoException;

class AnnulerCommandeTest {

	@Test
	void testAnnulerCommande() {
		Client client = new Client();
		client.setIdentifiant(1);
        client.setEmail("moussa@gmail.com");
        client.setMotDePass("moussamdp123");
        client.setNom("Ba");
        client.setPrenom("moussa");
        try {
        	 DaoFactory daoFactory = DaoFactory.getInstance();
             CommandeDao commandeDao = daoFactory.getCommandeDao();
             boolean test = commandeDao.annulerCommande(client,8);
             assertEquals(true,test);
		} catch (DaoException e) {
            e.getMessage();
		}
	}

}
