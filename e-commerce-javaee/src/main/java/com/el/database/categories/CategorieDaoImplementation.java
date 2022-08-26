package com.el.database.categories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.el.beans.Categorie;
import com.el.database.daofactory.DaoFactory;
import com.el.exceptions.DaoException;

public class CategorieDaoImplementation implements CategorieDao {
	private DaoFactory daoFactory;
	
	public CategorieDaoImplementation(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
	}

	// pour ajouter un categorie dans la base
	@Override
	public boolean ajouterCategorie(Categorie categorie) throws DaoException {
        boolean ajoueReussie = false;
        Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = daoFactory.getConnection(); // recuperation de la connection
			String requeteSql = "INSERT INTO categories(nomCategorie) VALUES(?)";
			preparedStatement = connection.prepareStatement(requeteSql);
			preparedStatement.setString(1, categorie.getNom());
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

	// pour supprimer un categorie dans la base
	@Override
	public boolean supprimerCategorie(int idCategorie) throws DaoException {
		boolean suppresssionReussie = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = daoFactory.getConnection();
			String requeteSql = "DELETE FROM categories WHERE idCategorie = ?";
			preparedStatement = connection.prepareStatement(requeteSql);
			preparedStatement.setInt(1, idCategorie);
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
				suppresssionReussie = true;
			} catch (SQLException e) {
				throw new DaoException("impossible de communiquer avec la base de données");
			}
		}

		
		return suppresssionReussie;
	}

	// pour lister l'ensemble des categorie
	@Override
	public List<Categorie> listerCategorie() throws DaoException {
        List<Categorie> categories = new ArrayList<Categorie>();
        Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null; 

		try {
			connection = daoFactory.getConnection();
			String requeteSql = "SELECT * FROM categories";
			preparedStatement = connection.prepareStatement(requeteSql);
			resultSet = preparedStatement.executeQuery();
			connection.commit(); // validation de la transaction
			// tant que il ya des  categories , on l'est ajoute dans la liste
			while (resultSet.next()) {
				Categorie categorie = new Categorie();
				categorie.setIdentifiant(resultSet.getInt("idCategorie"));
				categorie.setNom(resultSet.getString("nomCategorie"));
				
				categories.add(categorie);
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
		
		return categories;
	}

}
