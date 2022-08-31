package com.el.beans;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import jakarta.servlet.http.Part;

public class Image {
	private int identifiant;
	private  String url;
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

	// pour ecrire le fichier dans notre disque ou dans notre serveur si c'est deployer
	public void ecrireFichier(Part part, String nomFichier, int tailleTampon) throws IOException {
		BufferedInputStream entree = null;
		BufferedOutputStream sortie = null;
		try {
			entree = new BufferedInputStream(part.getInputStream(), tailleTampon);
			sortie = new BufferedOutputStream(new FileOutputStream(new File(url + nomFichier)), tailleTampon);

			byte[] tampon = new byte[tailleTampon];
			int longueur;
			while ((longueur = entree.read(tampon)) > 0) {
				sortie.write(tampon, 0, longueur);
			}
		} finally {
			try {
				sortie.close();
			} catch (IOException ignore) {
			}
			try {
				entree.close();
			} catch (IOException ignore) {
			}
		}
	}
}
