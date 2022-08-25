package com.el.database.livreurs;

import java.util.List;

import com.el.beans.Livraison;
import com.el.beans.Livreur;
import com.el.database.daofactory.DaoFactory;
import com.el.exceptions.DaoException;

public class LivreurDaoImplementation implements LivreurDao {
    private DaoFactory daoofactory;
	
	public LivreurDaoImplementation(DaoFactory daoFactory) {
        this.daoofactory = daoFactory;
    }
	@Override
	public boolean ajouterLivreur(Livraison livreur) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supprimerLivreur(Livraison livreur) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mettreAjourNumeroTelephone(Livraison livreur, String nouveauNumero) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Livreur> listerLivreur() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Livraison> LivraisonEffectuer(Livreur livreur) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
