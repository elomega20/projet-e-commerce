package com.el.database.livraisons;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.el.beans.Livraison;
import com.el.beans.Livreur;
import com.el.database.daofactory.DaoFactory;
import com.el.exceptions.DaoException;

public class LivraisonDaoImplemantation implements LivraisonDao {
	private DaoFactory daoFactory;

	public LivraisonDaoImplemantation(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	// pour attribuer une livraison a un livreur
	@Override
	public boolean effectuerLivraison(Livraison livraison) throws DaoException {
		boolean livraisonEffectuer = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = daoFactory.getConnection(); // recuperation de la connection
			String requeteSql = "INSERT INTO livraisons(adressDestination,idLivreur) VALUES(?,?)";
			preparedStatement = connection.prepareStatement(requeteSql);
			preparedStatement.setString(1, livraison.getAdressDestination());
			preparedStatement.setInt(2, livraison.getIdentifiantLivreur());
			preparedStatement.executeUpdate();
			connection.commit(); // validation de la transaction
		} catch (SQLException e) { // s'il ya une exception de type SQLException
			try {
				if (connection != null) {
					connection.rollback(); // annulation de la transaction
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					connection.close();
				}
			} catch (SQLException e1) {
			}
			throw new DaoException("impossible de communiquer avec la base de données");
		} finally { // si tout c'est bien passer
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
				livraisonEffectuer = true;
			} catch (SQLException e) {
				throw new DaoException("impossible de communiquer avec la base de données");
			}
		}

		return livraisonEffectuer;
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
