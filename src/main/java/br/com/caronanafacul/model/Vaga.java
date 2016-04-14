package br.com.caronanafacul.model;

import java.math.BigDecimal;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "vaga")
public class Vaga {

	@Id
	@Access(AccessType.FIELD)
	@SequenceGenerator(name = "genVaga", sequenceName = "vaga_id_seq")
	@Column(name = "id_vaga", unique = true, nullable = false)
	@GeneratedValue(generator = "genVaga")
	private long id;
	
	@Access(AccessType.FIELD)
	@Column(name = "descricao_vaga")
	private String descricao;
	
	@Access(AccessType.FIELD)
	@Column(name = "valor_vaga")
	private BigDecimal valor;
	
	@Enumerated(EnumType.ORDINAL)
	@Access(AccessType.FIELD)
	@Column(name = "estado_vaga", nullable = false)
	private EstadoVaga estado;
	
	@ManyToOne
	@Access(AccessType.FIELD)
	@JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
	private Usuario usuario;
	
	Vaga() {
		//Construtor pro hibernate
	}

	public Vaga(long id, String descricao, BigDecimal valor, EstadoVaga estado) {
		//TODO assumir invariantes
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.estado = estado;
	}
	
	public Vaga(String descricao, BigDecimal valor, EstadoVaga estado) {
		this(0l, descricao, valor, estado);
	}

	public long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public EstadoVaga getEstado() {
		return estado;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public void inscreverCaroneiro(Usuario usuario){
		//TODO implementar isso
	}
}