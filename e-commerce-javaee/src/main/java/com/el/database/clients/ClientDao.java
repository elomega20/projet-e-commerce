package com.el.database.clients;

import java.util.List;

import com.el.beans.Client;
import com.el.exceptions.DaoException;

/*On utilise une interface pour définir 
 * les méthodes d'accès aux données des clients, 
 * indépendamment de la méthode de stockage. On indique 
 * juste des noms de méthodes ici.*/

public interface ClientDao {
    public boolean ajouterClient(Client client) throws DaoException;
    public boolean supprimerClient(int idClient) throws DaoException;
    public List<Client> listerClient() throws DaoException;
    public boolean mettreAjourEmail(Client client,String nouveauEmail) throws DaoException;
    public boolean reinitialiserMotDePass(Client client) throws DaoException;
    public boolean modifierMotDePass(Client client,String nouveauMotdePass) throws DaoException;
    public Client profileClient(int idClient) throws DaoException;
}
