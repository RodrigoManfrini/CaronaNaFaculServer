package br.com.caronanafacul.dao;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

//TODO colocar algum controle de transação que não seja manual
//Visibilidade de pacote porque não é essa classe que deve controlar a transação
class ConnectionHelper {
	
	private static final String SAVE_ERROR_MESSAGE = "ERRO AO SALVAR O OBJETO!";
	private static final String GET_ERROR_MESSAGE = "ERRO AO RECUPERAR O OBJETO!";
	private static final String DELETE_ERROR_MESSAGE = "ERRO AO DELETAR O OBJETO!";
	
	//TODO injeção de dependência
	private SessionFactory sessionFactory;	
	
	public ConnectionHelper() {
		Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistryBuilder ssrb = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(ssrb.buildServiceRegistry());
	}

	public Object merge(final Object object) throws DAOException {
		Session session = null;
		Transaction transacao = null;

		try {
			session = getSessionFactory().openSession();
			transacao = session.beginTransaction();
			Object objetoInserido = session.merge(object);
			transacao.commit();
			session.flush();
			return objetoInserido;
		} catch (final HibernateException ex) {
			ex.printStackTrace();
			throw new DAOException(SAVE_ERROR_MESSAGE, ex);
		}finally {
			session.close();
		}
	}
	
	public void save(final Object object) throws DAOException {
		Session session = null;
		Transaction transacao = null;
		
		try {
			session = getSessionFactory().openSession();
			transacao = session.beginTransaction();
			session.saveOrUpdate(object);
			transacao.commit();
			session.flush();
		} catch (final HibernateException ex) {
			ex.printStackTrace();
			throw new DAOException(SAVE_ERROR_MESSAGE, ex);
		}finally {
			session.close();
		}
	}

	public <E> Object getById(final Class<E> clazz, final Serializable id) throws DAOException {
		Session session = null;
		Transaction transacao = null;

		try {
			session = getSessionFactory().openSession();
			transacao = session.beginTransaction();
			Object object = session.get(clazz, id);
			return object;
		} catch (final HibernateException ex) {
			ex.printStackTrace();
			throw new DAOException(GET_ERROR_MESSAGE, ex);
		}finally {
			session.close();
		}
	}

	public void delete(final Object object) throws DAOException {
		Session session = null;
		//TODO delete muda para 1
		try {

			session = getSessionFactory().openSession();
			session.delete(object);
		} catch (final HibernateException ex) {
			throw new DAOException(DELETE_ERROR_MESSAGE, ex);
		}finally {
			session.close();
		}
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}