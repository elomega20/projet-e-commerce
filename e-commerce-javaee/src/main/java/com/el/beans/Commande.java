package com.el.beans;

import java.sql.Date;

public class Commande {
    private int identifiant;
    private Date dateCommande;
    private String commandeReglee;
    
	public int getIdentifiant() {
		return identifiant;
	}
	
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}
	
	public Date getDateCommande() {
		return dateCommande;
	}
	
	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}
	
	public String getCommandeReglee() {
		return commandeReglee;
	}
	
	public void setCommandeReglee(String commandeReglee) {
		this.commandeReglee = commandeReglee;
	}
}
