package com.el.beans;

public class CommandeArticle {
	private int identifiantCommande;
	private int identifiantArticle;
	private int numeroPayement;
	private int identifiantLivraison;
	private int quantite;
	private int prixTotal;

	public int getNumeroPayement() {
		return numeroPayement;
	}

	public void setNumeroPayement(int numeroPayement) {
		this.numeroPayement = numeroPayement;
	}

	public int getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(int prixTotal) {
		this.prixTotal = prixTotal;
	}

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
