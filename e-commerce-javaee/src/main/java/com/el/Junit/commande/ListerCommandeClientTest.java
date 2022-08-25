package com.el.Junit.commande;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.el.beans.Client;
import com.el.beans.Commande;
import com.el.database.commandes.CommandeDao;
import com.el.database.daofactory.DaoFactory;
import com.el.exceptions.DaoException;

class ListerCommandeClientTest {

	@Test
	void testListerCommandeClient() {
		Client client = new Client();
		client.setIdentifiant(1);
		client.setEmail("moussa@gmail.com");
		client.setMotDePass("moussamdp123");
		client.setNom("Ba");
		client.setPrenom("moussa");
		try {
			DaoFactory daoFactory = DaoFactory.getInstance();
			CommandeDao commandeDao = daoFactory.getCommandeDao();
			List<Commande> commandes = new ArrayList<Commande>();
			commandes = commandeDao.listerCommandeClient(client);
			for (Commande commande : commandes) {
				System.out.println(commande.getIdentifiant());
				System.out.println(commande.getCommandeReglee());
				System.out.println(commande.getDateCommande());
			}
		} catch (DaoException e) {
			e.getMessage();
		}
	}

}
