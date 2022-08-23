package com.el.beans;

public class Payement {
    private int identifiant;
    private String numeroTelephone;
    private String modePayement;
    
	public int getIdentifiant() {
		return identifiant;
	}
	
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}
	
	public String getNumeroTelephone() {
		return numeroTelephone;
	}
	
	public void setNumeroTelephone(String numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}
	
	public String getModePayement() {
		return modePayement;
	}
	
	public void setModePayement(String modePayement) {
		this.modePayement = modePayement;
	}
}
