package com.el.beans;

import jakarta.servlet.http.Part;

public class Image {
	private int identifiant;
	private String url;
	private int identifiantArticle;

	public int getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getIdentifiantArticle() {
		return identifiantArticle;
	}

	public void setIdentifiantArticle(int identifiantArticle) {
		this.identifiantArticle = identifiantArticle;
	}

	// extrait le nom de l'image a partir de l'url
	public String getNomImage(Part part) {
		for (String contentDisposition : part.getHeader("content-disposition").split(";")) {
			if (contentDisposition.trim().startsWith("filename")) {
				return contentDisposition.substring(contentDisposition.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}
}
