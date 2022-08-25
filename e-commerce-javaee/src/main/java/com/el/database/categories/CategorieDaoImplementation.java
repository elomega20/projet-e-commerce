package com.el.database.categories;

import java.util.ArrayList;
import java.util.List;

import com.el.beans.Categorie;
import com.el.database.daofactory.DaoFactory;
import com.el.exceptions.DaoException;

public class CategorieDaoImplementation implements CategorieDao {
	private DaoFactory daoFactory;
	
	public CategorieDaoImplementation(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
	}

	// pour ajouter un categorie dans la base
	@Override
	public boolean ajouterCategorie(Categorie categorie) throws DaoException {
        boolean ajoueReussie = false;
        
        return ajoueReussie;
	}

	// pour supprimer un categorie dans la base
	@Override
	public boolean supprimerCategorie(int idCategorie) throws DaoException {
		boolean suppresssionReussie = false;
		
		return suppresssionReussie;
	}

	// pour lister l'ensemble des categorie
	@Override
	public List<Categorie> listerCategorie() throws DaoException {
        List<Categorie> categories = new ArrayList<Categorie>();
		
		return categories;
	}

}
