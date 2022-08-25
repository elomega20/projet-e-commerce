package com.el.database.livreurs;

import java.util.List;

import com.el.beans.Livraison;
import com.el.beans.Livreur;
import com.el.exceptions.DaoException;

public interface LivreurDao {
    public boolean ajouterLivreur(Livraison livreur) throws DaoException;
    public boolean supprimerLivreur(Livraison livreur) throws DaoException;
    public boolean mettreAjourNumeroTelephone(Livraison livreur,String nouveauNumero) throws DaoException;
    public List<Livreur> listerLivreur() throws DaoException;
    public List<Livraison> LivraisonEffectuer(Livreur livreur) throws DaoException;
}
