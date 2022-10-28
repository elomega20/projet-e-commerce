package com.el.database.images;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.el.beans.Article;
import com.el.beans.Image;
import com.el.database.daofactory.DaoFactory;
import com.el.exceptions.DaoException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

public class ImageDaoImplementation implements ImageDao {
	private DaoFactory daoFactory;

	// constructeur
	public ImageDaoImplementation(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	// pour ajouter une image dans la base
	@Override
	public boolean ajouterImage(Image image) throws DaoException {
		boolean ajoueReussie = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		// on met l'objet image dans la base
		try {
			connection = daoFactory.getConnection(); // recuperation de la connection
			String requeteSql = "INSERT INTO images(urlImage,idArticle) VALUES(?,?)";
			preparedStatement = connection.prepareStatement(requeteSql);
			preparedStatement.setString(1, image.getNom());
			preparedStatement.setInt(2, image.getIdentifiantArticle());
			preparedStatement.executeUpdate();
			connection.commit(); // validation de la transaction
		} catch (SQLException e) { // s'il ya une erreur de type SQLException
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

		// request.setAttribute("nomImage", image.getNom());

	return ajoueReussie;

	}

	// pour supprimer une image de la base
	@Override
	public boolean supprimerImage(int idImage) throws DaoException {
		boolean suppressionReussie = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = daoFactory.getConnection(); // recuperation de la connection
			String requeteSql = "DELETE FROM images WHERE idImage=?";
			preparedStatement = connection.prepareStatement(requeteSql);
			preparedStatement.setInt(1, idImage);
			preparedStatement.executeUpdate();
			connection.commit(); // validation de la transaction
		} catch (SQLException e) { // s'il ya une erreur de type SQLException
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

	// pour lister l'ensemble des images liés a un article
	@Override
	public List<Image> liserImageArticle(Article article) throws DaoException {
		List<Image> images = new ArrayList<Image>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = daoFactory.getConnection(); // recuperation de la connection
			String requeteSql = "SELECT * FROM images WHERE idArticle=?";
			preparedStatement = connection.prepareStatement(requeteSql);
			preparedStatement.setInt(1, article.getIdentifiant());
			resultSet = preparedStatement.executeQuery();
			connection.commit(); // validation de la transaction
			while (resultSet.next()) {
				Image image = new Image();
				image.setIdentifiant(resultSet.getInt("idImage"));
				image.setNom(resultSet.getString("urlImage"));
				image.setIdentifiantArticle(resultSet.getInt("idArticle"));
				images.add(image);
			}
		} catch (SQLException e) { // s'il ya une erreur de type SQLException
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

		return images;
	}

}
