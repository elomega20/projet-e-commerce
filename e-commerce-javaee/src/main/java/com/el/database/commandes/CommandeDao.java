package com.el.database.commandes;

import java.util.List;

import com.el.beans.Client;
import com.el.beans.Commande;
import com.el.exceptions.DaoException;

public interface CommandeDao {
    public boolean passerCommande(Client client) throws DaoException;
    public boolean annulerCommande(Client client,int idCommade) throws DaoException;
    public List<Commande> listerCommandeClient(Client client) throws DaoException;
    public int suivreCommande(Client client,Commande commande) throws DaoException;
    public Commande rechercherCommandeViaSonIdentifiant(int idCommande) throws DaoException;
}
