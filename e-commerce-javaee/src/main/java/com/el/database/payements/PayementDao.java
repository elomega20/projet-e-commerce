package com.el.database.payements;

import java.util.List;

import com.el.beans.CommandeArticle;
import com.el.beans.Payement;
import com.el.exceptions.DaoException;

public interface PayementDao {
	public boolean ajouterPayement(Payement payement) throws DaoException;
	public boolean supprimerPayement(int idPayement) throws DaoException;
    public boolean payerEnLigne(Payement payement,List<CommandeArticle> commandeArticles) throws DaoException;
}
