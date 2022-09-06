package com.el.database.payements;

import com.el.beans.Payement;
import com.el.exceptions.DaoException;

public interface PayementDao {
	public boolean ajouterPayement(Payement payement) throws DaoException;
	public boolean supprimerPayement(int idPayement) throws DaoException;
}
