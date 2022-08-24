package com.el.database.clients;

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
    
    @Override
    public boolean ajouterClient(Client client) throws DaoException {
    	boolean ajoueReussie =false;
    	
    	
        return ajoueReussie;
    }
    
    @Override
    public boolean supprimerClient(int idClient) throws DaoException {
    	boolean suppressionReussie = false;
    	
    	return suppressionReussie;
    }
   
    @Override
    public List<Client> listerClient() throws DaoException {
    	List<Client> clients = new ArrayList<Client>();
    	
    	return clients;
    }
    
    @Override
    public boolean mettreAjourEmail(Client client,String nouveauEmail) throws DaoException {
    	boolean miseAjourReussie = false;
    	
    	return miseAjourReussie;
    }
    
    @Override
    public boolean reinitialiserMotDePass(Client client) throws DaoException {
    	boolean reinitialisationReussie = false;
    	
    	return reinitialisationReussie;
    }
    
    @Override
    public boolean modifierMotDePass(Client client,String nouveauMotdePass) throws DaoException {
    	boolean modificationReussie = false;
    	
    	return modificationReussie;
    }
    
    @Override
    public Client profileClient(int idClient) throws DaoException {
    	Client client = new Client();
    	
    	return client;
    }
}
