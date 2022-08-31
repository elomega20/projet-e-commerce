package com.el.database.images;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
	public boolean ajouterImage(HttpServletRequest request, Image image, String cheminAbsolue) throws DaoException {
		boolean ajoueReussie = false;
		final int TAILLE_TAMPON = 10240;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		// On récupère le champ du fichier
		Part part = null;
		try {
			part = request.getPart("fichier");
		} catch (IOException | ServletException e) {
			e.printStackTrace();
		}

		// On vérifie qu'on a bien reçu un fichier
		String nomImage = image.getNomImage(part);
		image.setNom(nomImage);

		// Si on a bien un fichier
		if (nomImage != null && !nomImage.isEmpty()) {
			// On écrit définitivement le fichier sur le disque
			try {
				image.ecrireFichier(part, nomImage, cheminAbsolue, TAILLE_TAMPON);
			} catch (IOException e) {
				e.printStackTrace();
			}

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

			request.setAttribute("nomImage", image.getNom());
		}

		return ajoueReussie;
	}

	// pour supprimer une image de la base
	@Override
	public boolean supprimerImage(int idImage) throws DaoException {
		boolean suppressionReussie = false;

		return suppressionReussie;
	}

	// pour lister l'ensemble des images liés a un article
	@Override
	public List<Image> liserImageArticle(Article article) throws DaoException {
		List<Image> images = new ArrayList<Image>();

		return images;
	}

}
