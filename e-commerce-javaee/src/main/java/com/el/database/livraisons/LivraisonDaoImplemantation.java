package com.el.database.livraisons;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

	// la liste des livraisons effectuer
	@Override
	public List<Livraison> livraisonEffectuer() throws DaoException {
		List<Livraison> livraisons = new ArrayList<Livraison>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = daoFactory.getConnection(); // recuperation de la connection
			String requeteSql = "SELECT * FROM livraisons WHERE livraisonEffectuer=?";
			preparedStatement = connection.prepareStatement(requeteSql);
			preparedStatement.setBoolean(1, true);
			resultSet = preparedStatement.executeQuery();
			connection.commit(); // validation de la transaction
			while (resultSet.next()) {
				Livraison livraison = new Livraison();
				livraison.setIdentifiant(resultSet.getInt("idLivraison"));
				livraison.setAdressDestination(resultSet.getString("adressDestination"));
				livraison.setLivraisonEffectuer(resultSet.getBoolean("livraisonEffectuer"));
				livraison.setIdentifiantLivreur(resultSet.getInt("idLivreur"));
				livraisons.add(livraison);
			}
		} catch (SQLException e) { // s'il ya une exception de type SQLException
			try {
				if (connection != null) {
					connection.rollback(); // annulation de la transaction
					if (resultSet != null) {
						resultSet.close();
					}
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
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new DaoException("impossible de communiquer avec la base de données");
			}
		}

		return livraisons;
	}

	// la liste des livraisons non effectuer
	@Override
	public List<Livraison> livraisonNonEffectuer() throws DaoException {
		List<Livraison> livraisons = new ArrayList<Livraison>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = daoFactory.getConnection(); // recuperation de la connection
			String requeteSql = "SELECT * FROM livraisons WHERE livraisonEffectuer=?";
			preparedStatement = connection.prepareStatement(requeteSql);
			preparedStatement.setBoolean(1, false);
			resultSet = preparedStatement.executeQuery();
			connection.commit(); // validation de la transaction
			while (resultSet.next()) {
				Livraison livraison = new Livraison();
				livraison.setIdentifiant(resultSet.getInt("idLivraison"));
				livraison.setAdressDestination(resultSet.getString("adressDestination"));
				livraison.setLivraisonEffectuer(resultSet.getBoolean("livraisonEffectuer"));
				livraison.setIdentifiantLivreur(resultSet.getInt("idLivreur"));
				livraisons.add(livraison);
			}
		} catch (SQLException e) { // s'il ya une exception de type SQLException
			try {
				if (connection != null) {
					connection.rollback(); // annulation de la transaction
					if (resultSet != null) {
						resultSet.close();
					}
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
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new DaoException("impossible de communiquer avec la base de données");
			}
		}

		return livraisons;
	}

}
