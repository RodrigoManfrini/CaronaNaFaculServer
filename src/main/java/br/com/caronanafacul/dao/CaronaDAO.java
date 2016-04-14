package br.com.caronanafacul.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.Restrictions;

import br.com.caronanafacul.model.Carona;
import br.com.caronanafacul.model.Usuario;

public class CaronaDAO extends AbstractDAO<Carona, Long> {

	public Collection<Carona> findAll() {
		@SuppressWarnings("unchecked")
		final List<Carona> caronas = hibernateHelper.getSessionFactory().openSession().createCriteria(Carona.class)
				.list();
		return caronas;
	}

	public Carona findById(Integer id) {

		final Carona carona = (Carona) hibernateHelper.getSessionFactory().openSession().createCriteria(Carona.class)
				.add(Restrictions.eq("id", id)).uniqueResult();

		return carona;
	}

	public List<Carona> findByIdUsuario(Integer id) {

		@SuppressWarnings("unchecked")
		final List<Carona> caronas = (List<Carona>)hibernateHelper.getSessionFactory().openSession()
				.createCriteria(Carona.class).add(Restrictions.eq("usuario.id", id)).list();

		return caronas;
	}

	public List<Carona> findByUsuario(Usuario usuario) {

		@SuppressWarnings("unchecked")
		final List<Carona> caronas = (List<Carona>) hibernateHelper.getSessionFactory().openSession()
				.createCriteria(Carona.class).add(Restrictions.eq("usuario.id", usuario.getId())).list();

		return caronas;
	}
}