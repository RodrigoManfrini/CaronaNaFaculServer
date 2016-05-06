package br.com.caronanafacul.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.com.caronanafacul.dao.CaronaDAO;
import br.com.caronanafacul.dao.DAOException;
import br.com.caronanafacul.model.Carona;

@Path(value = "/carona")
public class CaronaController {

	// TODO usar injeção de dependência
	private CaronaDAO caronaDAO = new CaronaDAO();

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void put(Carona carona) {
		System.out.println("Dentro do put no servidor"+carona.toString());
		try {
			caronaDAO.save(carona);
		
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public Collection<Carona> getAll() {
//		return caronaDAO.findAll();
//		
//	}
	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public Carona getById(@QueryParam(value = "id") int id) {
//		return caronaDAO.findById(id);
//	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Carona> getAllByUser(@QueryParam(value = "user") int id) {
		return caronaDAO.findByIdUsuario(id);
	}
}