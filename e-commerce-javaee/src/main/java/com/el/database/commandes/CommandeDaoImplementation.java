package com.el.database.commandes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.el.beans.Client;
import com.el.beans.Commande;
import com.el.database.daofactory.DaoFactory;
import com.el.exceptions.DaoException;

/*L'implémentation réelle des méthodes 
 * de l'interface CommandeDao
 *(le code à l'intérieur) indiquera si on 
 *stocke en SQL dans MySQL, dans Oracle, 
 *dans des fichiers ou ailleurs*/

public class CommandeDaoImplementation implements CommandeDao {
	private DaoFactory daoFactory;
	
	// constructeur
	public CommandeDaoImplementation(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	// permette a un client de passer une commande
	@Override
	public boolean passerCommande(Client client) throws DaoException
	{
		boolean passerCommandeReussie = true;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		Commande commande = new Commande();
		Calendar cal = new GregorianCalendar();
		int annee = cal.get(Calendar.YEAR);
		int mois = cal.get(Calendar.MONTH);
		int jour = cal.get(Calendar.DAY_OF_MONTH);
		String date = Integer.toString(jour) +"-"+ Integer.toString(mois) +"-"+ Integer.toString(annee);
		commande.setDateCommande(date);
		commande.setIdentifiantClient(client.getIdentifiant());
		
		try {
			connection = daoFactory.getConnection();
			String requeteSql = "INSERT INTO commandes(dateCommande,idClient) VALUES(?,?)";
			preparedStatement = connection.prepareStatement(requeteSql);
			preparedStatement.setString(1, commande.getDateCommande());
			preparedStatement.setInt(2, commande.getIdentifiantClient());
			preparedStatement.executeUpdate();
			connection.commit();
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
				if (connection != null) {
					connection.close();
				}
				passerCommandeReussie = true;
			} catch (SQLException e) {
				throw new DaoException("impossible de communiquer avec la base de données");
			}
		}
		
		return passerCommandeReussie;
	}

	// permettre a un client d'annuler une commande
	@Override
	public boolean annulerCommande(Client client,int idCommade) throws DaoException {
		boolean annulerCommandeReussie = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = daoFactory.getConnection();
			String requeteSql = "DELETE FROM commandes WHERE idCommande=? AND idClient=?";
			preparedStatement = connection.prepareStatement(requeteSql);
			preparedStatement.setInt(1, idCommade);
			preparedStatement.setInt(2, client.getIdentifiant());	
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
				if (connection != null) {
					connection.close();
				}
				annulerCommandeReussie = true;
			} catch (SQLException e) {
				throw new DaoException("impossible de communiquer avec la base de données");
			}
		}
		
		return annulerCommandeReussie;
	}

	// permette de lister l'ensemble des commandes du client
	@Override
	public List<Commande> listerCommandeClient(Client client) throws DaoException {
		List<Commande> commandes = new ArrayList<Commande>();
		
		return commandes;
	}

	// permette de connetre l'etat d'avancement de la commande 
	@Override
	public int suivreCommande(Client client,Commande commande) throws DaoException {
		int etat = 0;
		
		return etat;
	}

	// recherche et revoie une commande
	@Override
	public Commande rechercherCommandeViaSonIdentifiant(int idCommande) throws DaoException {
        Commande commande = new Commande();
        
        return commande;
	}
}
