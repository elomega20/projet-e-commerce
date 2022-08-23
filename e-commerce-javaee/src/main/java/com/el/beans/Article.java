package com.el.beans;

public class Article {
    private int identifiant;
    private String designation;
    private String detail;
    private int prixUnitaire;
    private int stock;
    private int identifiantCategorie;
    
	public int getIdentifiant() {
		return identifiant;
	}
	
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}
	
	public String getDesignation() {
		return designation;
	}
	
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public String getDetail() {
		return detail;
	}
	
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	public int getPrixUnitaire() {
		return prixUnitaire;
	}
	
	public void setPrixUnitaire(int prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public int getIdentifiantCategorie() {
		return identifiantCategorie;
	}

	public void setIdentifiantCategorie(int identifiantCategorie) {
		this.identifiantCategorie = identifiantCategorie;
	}
}
