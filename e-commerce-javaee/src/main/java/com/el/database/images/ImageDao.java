package com.el.database.images;

import java.util.List;

import com.el.beans.Article;
import com.el.beans.Image;
import com.el.exceptions.DaoException;

import jakarta.servlet.http.HttpServletRequest;

public interface ImageDao {
    public boolean ajouterImage(HttpServletRequest request, Image image,String cheminAbsolue) throws DaoException;
    public boolean supprimerImage(int idImage) throws DaoException;
    public List<Image> liserImageArticle(Article article) throws DaoException;
}
