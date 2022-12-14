package com.el.database.livreurs;

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

public class LivreurDaoImplementation implements LivreurDao {
	private DaoFactory daoFactory;

	public LivreurDaoImplementation(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	// pour ajouter un livreur dans la base
	@Override
	public boolean ajouterLivreur(Livreur livreur) throws DaoException {
		boolean ajoueReussie = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = daoFactory.getConnection(); // recuperation de la connection
			String requeteSql = "INSERT INTO livreurs(nomComplet,numTelephone,disponibilite) VALUES(?,?,?)";
			preparedStatement = connection.prepareStatement(requeteSql);
			preparedStatement.setString(1, livreur.getNomComplet());
			preparedStatement.setString(2, livreur.getNumeroTelephone());
			preparedStatement.setBoolean(3, livreur.isDisponibilite());
			preparedStatement.executeUpdate();
			connection.commit(); // validation de la transaction
		} catch (SQLException e) {
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
		} finally {
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

	// pour supprimer un livreur dans la base
	@Override
	public boolean supprimerLivreur(Livreur livreur) throws DaoException {
		boolean suppressionReussie = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = daoFactory.getConnection(); // recuperation de la connection
			String requeteSql = "DELETE FROM livreurs WHERE idLivreur=?";
			preparedStatement = connection.prepareStatement(requeteSql);
			preparedStatement.setInt(1, livreur.getIdentifiant());
			preparedStatement.executeUpdate();
			connection.commit(); // validation de la transaction
		} catch (SQLException e) {
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
		} finally {
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

	// pour mettre a jour le numero de telephone du livreur
	@Override
	public boolean mettreAjourNumeroTelephone(Livreur livreur, String nouveauNumero) throws DaoException {
		boolean miseAjourReussie = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = daoFactory.getConnection(); // recuperation de la connection
			String requeteSql = "UPDATE livreurs SET numTelephone=? WHERE idLivreur=?";
			preparedStatement = connection.prepareStatement(requeteSql);
			preparedStatement.setString(1, nouveauNumero);
			preparedStatement.setInt(2, livreur.getIdentifiant());
			preparedStatement.executeUpdate();
			connection.commit(); // validation de la transaction
		} catch (SQLException e) {
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
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
				miseAjourReussie = true;
			} catch (SQLException e) {
				throw new DaoException("impossible de communiquer avec la base de données");
			}
		}

		return miseAjourReussie;
	}

	// permette de lister l'ensemble des livreurs
	@Override
	public List<Livreur> listerLivreur() throws DaoException {
		List<Livreur> livreurs = new ArrayList<Livreur>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = daoFactory.getConnection(); // recuperation de la connection
			String requeteSql = "SELECT * FROM livreurs";
			preparedStatement = connection.prepareStatement(requeteSql);
			resultSet = preparedStatement.executeQuery();
			connection.commit(); // validation de la transaction
			while (resultSet.next()) {
				Livreur livreur = new Livreur();
				livreur.setIdentifiant(resultSet.getInt("idLivreur"));
				livreur.setNomComplet(resultSet.getString("nomComplet"));
				livreur.setNumeroTelephone(resultSet.getString("numTelephone"));
				livreur.setDisponibilite(resultSet.getBoolean("disponibilite"));
				livreurs.add(livreur);
			}
		} catch (SQLException e) {
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
		} finally {
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
		
		return livreurs;
	}

	// pour lister les livraisons effectués par un livreur
	@Override
	public List<Livraison> LivraisonEffectuer(Livreur livreur) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
