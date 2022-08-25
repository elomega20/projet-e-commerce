package com.el.database.livraisons;

import java.util.List;

import com.el.beans.Livraison;
import com.el.beans.Livreur;
import com.el.exceptions.DaoException;

public interface LivraisonDao {
    public boolean effectuerLivraison(Livreur livreur) throws DaoException;
    public List<Livraison> livraisonEffectuer() throws DaoException;
    public List<Livraison> livraisonNonEffectuer() throws DaoException;
}
