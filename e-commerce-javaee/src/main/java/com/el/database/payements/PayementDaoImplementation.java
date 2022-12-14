package com.el.database.payements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.el.beans.CommandeArticle;
import com.el.beans.Payement;
import com.el.database.daofactory.DaoFactory;
import com.el.exceptions.DaoException;

public class PayementDaoImplementation implements PayementDao {
	private DaoFactory daoFactory;

	public PayementDaoImplementation(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	// pour ajouter un payement
	@Override
	public boolean ajouterPayement(Payement payement) throws DaoException {
		boolean ajoueReussie = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = daoFactory.getConnection(); // recuperation de la connection
			String requeteSql = "INSERT INTO payements(numTelephone,modePayement) VALUES(?,?)";
			preparedStatement = connection.prepareStatement(requeteSql);
			preparedStatement.setString(1, payement.getNumeroTelephone());
			preparedStatement.setString(2, payement.getModePayement());
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
				ajoueReussie = true;
			} catch (SQLException e) {
				throw new DaoException("impossible de communiquer avec la base de données");
			}
		}

		return ajoueReussie;
	}

	// pour supprimer un payement
	@Override
	public boolean supprimerPayement(int idPayement) throws DaoException {
		boolean suppressionReussie = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = daoFactory.getConnection(); // recuperation de la connection
			String requeteSql = "DELETE FROM payements WHERE idPayement=?";
			preparedStatement = connection.prepareStatement(requeteSql);
			preparedStatement.setInt(1, idPayement);
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
				suppressionReussie = true;
			} catch (SQLException e) {
				throw new DaoException("impossible de communiquer avec la base de données");
			}
		}

		return suppressionReussie;
	}

}
