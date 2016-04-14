package br.com.caronanafacul.dao;

public class DAOException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DAOException(final String message) {
		super(message);
	}

	public DAOException(final Throwable t) {
		super(t);
	}

	public DAOException(final String message, final Throwable t) {
		super(message, t);
	}
}
