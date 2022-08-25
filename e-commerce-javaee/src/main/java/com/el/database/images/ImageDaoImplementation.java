package com.el.database.images;

import java.util.ArrayList;
import java.util.List;

import com.el.beans.Article;
import com.el.beans.Image;
import com.el.database.daofactory.DaoFactory;
import com.el.exceptions.DaoException;

public class ImageDaoImplementation implements ImageDao {
	private DaoFactory daoFactory;
	
	// constructeur
	public ImageDaoImplementation(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
	}

	// pour ajouter une image dans la base
	@Override
	public boolean ajouterImage(Image image) throws DaoException {
        boolean ajoueReussie = false;
		
		return ajoueReussie;
	}

	// pour supprimer une image de la base
	@Override
	public boolean supprimerImage(int idImage) throws DaoException {
        boolean suppressionReussie = false;
        
        return suppressionReussie;
	}

	// pour lister l'ensemble des images liés a un article
	@Override
	public List<Image> liserImageArticle(Article article) throws DaoException {
        List<Image> images = new ArrayList<Image>();
        
        return images;
	}

}
