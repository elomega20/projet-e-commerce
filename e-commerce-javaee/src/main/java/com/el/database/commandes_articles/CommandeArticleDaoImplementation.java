package com.el.database.commandes_articles;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.el.beans.Commande;
import com.el.beans.CommandeArticle;
import com.el.exceptions.DaoException;

public class CommandeArticleDaoImplementation implements CommandeArticleDao {

	/* elle renvoie une liste de Map
	 * contenant les articles , leur quantite correspondant
	 * et le prix total correspondant
	 */
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

	// renvoie la liste correspondant au article  commander
	@Override
	public List<CommandeArticle> listCommandearticle(Commande commande) throws DaoException {
        List<CommandeArticle> commandeArticles = new ArrayList<CommandeArticle>();
		
        return commandeArticles;
	}

}
