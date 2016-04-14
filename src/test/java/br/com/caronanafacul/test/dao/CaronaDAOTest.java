package br.com.caronanafacul.test.dao;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import br.com.caronanafacul.dao.CaronaDAO;
import br.com.caronanafacul.dao.UsuarioDAO;
import br.com.caronanafacul.model.Carona;
import br.com.caronanafacul.model.Usuario;

public class CaronaDAOTest {

	public static void main(String[] args) {
		CaronaDAO caronaDAO = new CaronaDAO();
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
//		try {
			Usuario usuario = usuarioDAO.findById(3);
			
			System.out.println(usuario);
			
			Date date = new Date(Calendar.getInstance().getTimeInMillis());
			
			Collection<Carona> caronas = caronaDAO.findAll();
			
			System.out.println("Todas as caronas: " + caronas);
			
			Carona carona = caronaDAO.findById(1);
			
			System.out.println("Carona com id: " + carona);
			
			Collection<Carona> caronasByUser = caronaDAO.findByUsuario(usuario);
			
			System.out.println("Caronas por usuário: " + caronasByUser);
			
//			Carona carona = new Carona("Carona teste user 2", 4,date, date, usuario);
			
//			caronaDAO.save(carona);
			
//		} catch (DAOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}