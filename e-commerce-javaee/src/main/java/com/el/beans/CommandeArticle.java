package com.el.beans;

public class CommandeArticle {
    private int identifiantCommande;
    private int identifiantArticle;
    private int identifiantPayement;
    private int identifiantLivraison;
    private int quantite;
    
	public int getIdentifiantCommande() {
		return identifiantCommande;
	}
	
	public void setIdentifiantCommande(int identifiantCommande) {
		this.identifiantCommande = identifiantCommande;
	}
	
	public int getIdentifiantArticle() {
		return identifiantArticle;
	}
	
	public void setIdentifiantArticle(int identifiantArticle) {
		this.identifiantArticle = identifiantArticle;
	}
	
	public int getIdentifiantPayement() {
		return identifiantPayement;
	}
	
	public void setIdentifiantPayement(int identifiantPayement) {
		this.identifiantPayement = identifiantPayement;
	}
	
	public int getIdentifiantLivraison() {
		return identifiantLivraison;
	}
	
	public void setIdentifiantLivraison(int identifiantLivraison) {
		this.identifiantLivraison = identifiantLivraison;
	}
	
	public int getQuantite() {
		return quantite;
	}
	
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
    
}
