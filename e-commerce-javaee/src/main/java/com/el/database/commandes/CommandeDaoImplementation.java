package com.el.database.commandes;

import java.util.ArrayList;
import java.util.List;

import com.el.beans.Client;
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
	@Override
	public boolean passerCommande(Client client,Commande commmande) throws DaoException
	{
		boolean passerCommandeReussie = false;
		
		return passerCommandeReussie;
	}

	// permettre de supprimer une commande dans la bse
	@Override
	public boolean annulerCommande(Client client,int idCommade) throws DaoException {
		boolean annulerCommandeReussie = false;
		
		return annulerCommandeReussie;
	}

	// permette de lister l'ensemble des commandes du client
	@Override
	public List<Commande> listerCommandeClient(Client client) throws DaoException {
		List<Commande> commandes = new ArrayList<Commande>();
		
		return commandes;
	}

	// permette de connetre l'etat d'avancement de la commande 
	@Override
	public int suivreCommande(Client client,Commande commande) throws DaoException {
		int etat = 0;
		
		return etat;
	}

	// recherche et revoie une commande
	@Override
	public Commande rechercherCommandeViaSonIdentifiant(int idCommande) throws DaoException {
        Commande commande = new Commande();
        
        return commande;
	}
}
