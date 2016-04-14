package br.com.caronanafacul.model;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "usuario")
@XmlRootElement(name = "usuario")
public class Usuario implements Serializable {

	@Id
	@Access(AccessType.FIELD)
	@Column(name = "id_usuario", unique = true, nullable = false)
	@SequenceGenerator(name = "genUsuario", sequenceName = "usuario_id_seq")
	@GeneratedValue(generator = "genUsuario")
	@XmlElement
	private Integer id;

	@XmlElement
	@Access(AccessType.FIELD)
	@Column(name = "email_usuario", length = 50, unique = true, nullable = false)
	private String email;

	@XmlElement
	@Access(AccessType.FIELD)
	@Column(name = "faculdade_usuario", length = 50)
	private String faculdade;

	protected Usuario() {
		// Construtor pro hibernate
	}

	public Usuario(Integer id, String email, String faculdade) {
		if (email == null) {
			throw new IllegalArgumentException("email null");
		}

		if (faculdade == null) {
			throw new IllegalArgumentException("faculdade null");
		}
		this.id = id;
		this.email = email;
		this.faculdade = faculdade;
	}

	public Usuario(String email, String faculdade) {
		// this(email, faculdade);
		this.email = email;
		this.faculdade = faculdade;
	}

	public Integer getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getFaculdade() {
		return faculdade;
	}
}