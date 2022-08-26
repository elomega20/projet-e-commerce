package com.el.Junit.commande;

import org.junit.jupiter.api.Test;

import com.el.beans.Commande;
import com.el.database.commandes.CommandeDao;
import com.el.database.daofactory.DaoFactory;
import com.el.exceptions.DaoException;

class RechercherCommandeViaSonIdentifiantTest {

	@Test
	void testRechercherCommandeViaSonIdentifiant() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        CommandeDao commandeDao = daoFactory.getCommandeDao();
        try {
			Commande commande = commandeDao.rechercherCommandeViaSonIdentifiant(10);
			
			System.out.println(commande.getIdentifiant());
			System.out.println(commande.getCommandeReglee());
			System.out.println(commande.getDateCommande());
			System.out.println(commande.getIdentifiantClient());
		} catch (DaoException e) {
            e.getMessage();
		}
	}

}
