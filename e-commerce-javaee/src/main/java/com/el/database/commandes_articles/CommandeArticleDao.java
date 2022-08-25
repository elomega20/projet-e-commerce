package com.el.database.commandes_articles;

import java.util.List;
import java.util.Map;

import com.el.beans.Commande;
import com.el.exceptions.DaoException;

public interface CommandeArticleDao {
	List<Map<String,String>> facture(Commande commande) throws DaoException;
	int totalFacture(Commande commande) throws DaoException;
}
