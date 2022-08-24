package com.el.database.commandes;

import java.util.ArrayList;
import java.util.List;

import com.el.beans.Commande;
import com.el.database.daofactory.DaoFactory;
import com.el.exceptions.DaoException;

/*L'implémentation réelle des méthodes 
 * de l'interface CommandeDao
 *(le code à l'intérieur) indiquera si on 
 *stocke en SQL dans MySQL, dans Oracle, 
 *dans des fichiers ou ailleurs*/

public class CommandeDaoImplementation implements CommandeDao {
	private DaoFactory daoFactory;
	
	// constructeur
	public CommandeDaoImplementation(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	// permette d'inséré une commande dans la base
	public boolean passerCommande(Commande commmande) throws DaoException
	{
		boolean passerCommandeReussie = false;
		
		return passerCommandeReussie;
	}

	// permettre de supprimer une commande dans la bse
	public boolean annulerCommande(int idCommade) throws DaoException {
		boolean annulerCommandeReussie = false;
		
		return annulerCommandeReussie;
	}

	// permette de lister l'ensemble des commandes du client
	public List<Commande> listerCommande() throws DaoException {
		List<Commande> commandes = new ArrayList<Commande>();
		
		return commandes;
	}

	// permette de connetre l'etat d'avancement de la commande 
	public int suivreCommande(Commande commande) throws DaoException {
		int etat = 0;
		
		return etat;
	}
}
