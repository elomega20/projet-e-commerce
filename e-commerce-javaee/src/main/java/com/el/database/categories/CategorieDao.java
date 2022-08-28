package com.el.database.categories;

import java.util.List;

import com.el.beans.Categorie;
import com.el.exceptions.DaoException;

// interface d'access au donnee de la classe categorie
public interface CategorieDao {
    public boolean ajouterCategorie(Categorie categorie) throws DaoException;
    public boolean supprimerCategorie(int idCategorie) throws DaoException;
    public List<Categorie> listerCategorie() throws DaoException;
    public Categorie rechercherCategorieViaSonIdentifiant(int idCategorie) throws DaoException;
}
