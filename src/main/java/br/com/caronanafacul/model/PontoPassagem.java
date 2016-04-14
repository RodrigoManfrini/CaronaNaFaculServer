package br.com.caronanafacul.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "ponto_passagem")
public class PontoPassagem {
	
	@Id
	@Access(AccessType.FIELD)
	@Column(name = "id_ponto_pass", unique = true, nullable = false)
	@SequenceGenerator(name = "genPontoPass", sequenceName = "ponto_pass_id_seq")
	@GeneratedValue(generator = "genPontoPass")
	private long id;
	
	@Access(AccessType.FIELD)
	@Column(name = "desc_ponto_pass",nullable = false)
	private String descricao;
	
	@Access(AccessType.FIELD)
	@Column(name = "temp_ponto_pass",nullable = false)
	private Date tempoEstimado;
	
	@Access(AccessType.FIELD)
	@Column(name = "long_ponto_pass")
	private BigDecimal longitude;
	
	@Access(AccessType.FIELD)
	@Column(name = "lat_ponto_pass")
	private BigDecimal latitude;
	
	PontoPassagem() {
		//Construtor pro hibernate
	}
	
	public PontoPassagem(long id, String descricao, Date tempoEstimado, BigDecimal longitude, BigDecimal latitude) {
		//TODO assumir invariantes
		this.id = id;
		this.descricao = descricao;
		this.tempoEstimado = tempoEstimado;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public PontoPassagem(String descricao, Date tempoEstimado, BigDecimal longitude, BigDecimal latitude) {
		this(0l,descricao, tempoEstimado, longitude, latitude);
	}

	public long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public Date getTempoEstimado() {
		return tempoEstimado;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}	
}