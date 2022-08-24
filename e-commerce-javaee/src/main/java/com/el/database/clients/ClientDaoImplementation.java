package com.el.database.clients;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.el.beans.Client;
import com.el.database.daofactory.DaoFactory;
import com.el.exceptions.DaoException;

/*L'implémentation réelle des méthodes 
 * de l'interface ClientDao
 *(le code à l'intérieur) indiquera si on 
 *stocke en SQL dans MySQL, dans Oracle, 
 *dans des fichiers ou ailleurs*/

public class ClientDaoImplementation implements ClientDao {
	private DaoFactory daoFactory;

	public ClientDaoImplementation(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	// ajouter un client dans la base de donnée
	@Override
	public boolean ajouterClient(Client client) throws DaoException {
		boolean ajoueReussie = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = daoFactory.getConnection();
			String requete = "INSERT INTO clients(email,motDePass,nomClient,prenomClient) VALUES(?,?,?,?)";
			preparedStatement = connection.prepareStatement(requete);
			preparedStatement.setString(1, client.getEmail());
			preparedStatement.setString(2, client.getMotDePass());
			preparedStatement.setString(3, client.getNom());
			preparedStatement.setString(4, client.getPrenom());
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
				if(connection != null) {
					connection.close();
				}
				ajoueReussie = true;
			} catch (SQLException e) {
				throw new DaoException("impossible de communiquer avec la base de données");
			}
		}

		return ajoueReussie;
	}

	// supprime un client dans la base de donnée
	@Override
	public boolean supprimerClient(int idClient) throws DaoException {
		boolean suppressionReussie = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection  = daoFactory.getConnection();
			String requete = "DELETE FROM clients WHERE idClient = ?";
			preparedStatement = connection.prepareStatement(requete);
			preparedStatement.setInt(1, idClient);
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
		}finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
				suppressionReussie = true;
			} catch (SQLException e) {
				throw new DaoException("impossible de communiquer avec la base de données");
			}
		}

		return suppressionReussie;
	}

	@Override
	public List<Client> listerClient() throws DaoException {
		List<Client> clients = new ArrayList<Client>();

		return clients;
	}

	@Override
	public boolean mettreAjourEmail(Client client, String nouveauEmail) throws DaoException {
		boolean miseAjourReussie = false;

		return miseAjourReussie;
	}

	@Override
	public boolean reinitialiserMotDePass(Client client) throws DaoException {
		boolean reinitialisationReussie = false;

		return reinitialisationReussie;
	}

	@Override
	public boolean modifierMotDePass(Client client, String nouveauMotdePass) throws DaoException {
		boolean modificationReussie = false;

		return modificationReussie;
	}

	@Override
	public Client profileClient(int idClient) throws DaoException {
		Client client = new Client();

		return client;
	}
}
