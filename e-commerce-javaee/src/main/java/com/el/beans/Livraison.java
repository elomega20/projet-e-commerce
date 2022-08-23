package com.el.beans;

public class Livraison {
    private int identifiant;
    private  String adressDestination;
    private boolean livraisonEffectuer;
    private int identifiantLivreur;
    
	public int getIdentifiant() {
		return identifiant;
	}
	
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}
	
	public String getAdressDestination() {
		return adressDestination;
	}
	
	public void setAdressDestination(String adressDestination) {
		this.adressDestination = adressDestination;
	}
	
	public boolean isLivraisonEffectuer() {
		return livraisonEffectuer;
	}
	
	public void setLivraisonEffectuer(boolean livraisonEffectuer) {
		this.livraisonEffectuer = livraisonEffectuer;
	}
	
	public int getIdentifiantLivreur() {
		return identifiantLivreur;
	}

	public void setIdentifiantLivreur(int identifiantLivreur) {
		this.identifiantLivreur = identifiantLivreur;
	}
}
