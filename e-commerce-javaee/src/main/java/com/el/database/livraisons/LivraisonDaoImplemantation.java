package com.el.database.livraisons;

import java.util.List;

import com.el.beans.Livraison;
import com.el.beans.Livreur;
import com.el.database.daofactory.DaoFactory;
import com.el.exceptions.DaoException;

public class LivraisonDaoImplemantation implements LivraisonDao {
    private DaoFactory  daoFactory;
    
    public LivraisonDaoImplemantation(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
    
	@Override
	public boolean effectuerLivraison(Livreur livreur) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Livraison> livraisonEffectuer() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Livraison> livraisonNonEffectuer() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
