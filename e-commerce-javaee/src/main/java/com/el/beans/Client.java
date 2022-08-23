package com.el.beans;

public class Client {
    private int identifiant;
    private String email;
    private String motDePass;
    private String nom;
    private String prenom;
    
	public int getIdentifiant() {
		return identifiant;
	}
	
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMotDePass() {
		return motDePass;
	}
	
	public void setMotDePass(String motDePass) {
		this.motDePass = motDePass;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
    
}
