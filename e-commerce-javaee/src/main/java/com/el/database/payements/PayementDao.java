package com.el.database.payements;

import java.util.List;

import com.el.beans.CommandeArticle;
import com.el.beans.Payement;
import com.el.exceptions.DaoException;

public interface PayementDao {
    public boolean payerEnLigne(Payement payement,List<CommandeArticle> commandeArticles) throws DaoException;
}
