package br.com.caronanafacul.dao;

import java.io.Serializable;


abstract class AbstractDAO<E, Id extends Serializable> {
	
	//TODO mudar pra injeção de dependência
	protected ConnectionHelper hibernateHelper;
	
	public AbstractDAO() {
		hibernateHelper = new ConnectionHelper();
	}

	public Object merge(final E object) throws DAOException {
		return hibernateHelper.merge(object);
	}
	
	public void save(final E object) throws DAOException {
		hibernateHelper.save(object);
	}

	public void delete(final E object) throws DAOException {
		hibernateHelper.delete(object);
	}
}