package com.el.exceptions;

// class d'exception liés aux javabeans 
public class BeanException extends Exception {
	private static final long serialVersionUID = 1L;
    public BeanException(String message) {
    	super(message);
    }
}
