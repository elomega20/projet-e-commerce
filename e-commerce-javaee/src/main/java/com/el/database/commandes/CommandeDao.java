package com.el.database.commandes;

import java.util.List;

import com.el.beans.Commande;
import com.el.exceptions.DaoException;

public interface CommandeDao {
    public boolean passerCommande(Commande commmande) throws DaoException;
    public boolean annulerCommande(int idCommade) throws DaoException;
    public List<Commande> listerCommande() throws DaoException;
    public int suivreCommande(Commande commande) throws DaoException;
}
