package com.el.database.commandes_articles;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.el.beans.Commande;
import com.el.exceptions.DaoException;

public class CommandeArticleDaoImplementation implements CommandeArticleDao {

	// elle renvoie une liste de Map
	@Override
	public List<Map<String, String>> facture(Commande commande) throws DaoException {
		List<Map<String, String>> factures = new ArrayList<Map<String, String>>();
		
		return factures;
	}

	// donne la somme total des articles acheter
	@Override
	public int totalFacture(Commande commande) throws DaoException {
        int totalFacture = 0;
        
        return totalFacture;
	}

}
