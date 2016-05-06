package br.com.caronanafacul.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.Restrictions;

import br.com.caronanafacul.model.Usuario;

public class UsuarioDAO extends AbstractDAO<Usuario, Integer> {
	
	public Collection<Usuario> findAll() {
		@SuppressWarnings("unchecked")
		final List<Usuario> usuarios = hibernateHelper.getSessionFactory().openSession().createCriteria(Usuario.class).list();
		return usuarios;
	}
	
	public Usuario findById(Integer id) {
		
		final Usuario usuario = (Usuario) hibernateHelper.getSessionFactory().openSession()
				.createCriteria(Usuario.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
		
		return usuario;
	}
	
	public Usuario findByEmail(String email) {
		
		final Usuario usuario = (Usuario) hibernateHelper.getSessionFactory().openSession()
				.createCriteria(Usuario.class)
				.add(Restrictions.eq("email", email))
				.uniqueResult();
		
		return usuario;
	}
	
	public Usuario findByFacebookId(Long facebookId) {
		
		final Usuario usuario = (Usuario) hibernateHelper.getSessionFactory().openSession()
				.createCriteria(Usuario.class)
				.add(Restrictions.eq("facebookId", facebookId))
				.uniqueResult();
		
		return usuario;
	}
	
}