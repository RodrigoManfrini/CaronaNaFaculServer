package br.com.caronanafacul.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "carona")
@XmlRootElement
public class Carona {

	@Id
	@Access(AccessType.FIELD)
	@Column(name = "id_carona", unique = true, nullable = false)
	@SequenceGenerator(name = "genCarona", sequenceName = "carona_id_seq")
	@GeneratedValue(generator = "genCarona")
	@XmlElement
	private Integer id;
	
	@Access(AccessType.FIELD)
	@Column(name = "p_partida_carona", nullable = false)
	@XmlElement
	private String pontoPartida;
	
	@Access(AccessType.FIELD)
	@Column(name = "num_vagas_carona", nullable = false)
	@XmlElement
	private int numeroVagas;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Access(AccessType.FIELD)
	@Column(name = "horario_carona", nullable = false)
	@XmlElement
	private Date horario;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Access(AccessType.FIELD)
	@Column(name = "temp_tol_carona", nullable = false)
	@XmlElement
	private Date tempoTolerancia;

	@ManyToOne
	@JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false)
	@Access(AccessType.FIELD)
	@XmlElement
	private Usuario usuario;	
	
	@OneToMany
	@JoinColumn(name = "id_carona", referencedColumnName = "id_carona", nullable = false)
	@Access(AccessType.FIELD)
	private Collection<Vaga> vagas;
	
	@OneToMany
	@JoinColumn(name = "id_carona", referencedColumnName = "id_carona")
	@Access(AccessType.FIELD)
	private Collection<PontoPassagem> pontosPassagem;
	
	Carona() {
		//Construtor pro hibernate
	}
	
	public Carona(Integer id, String pontoPartida, int numeroVagas, Date horario, Date tempoTolerancia, Usuario usuario) {
		//TODO assumir invariantes
		this.id = id;
		this.pontoPartida = pontoPartida;
		this.horario = horario;
		this.tempoTolerancia = tempoTolerancia;
		this.usuario = usuario;
		this.numeroVagas = numeroVagas;
		vagas = new ArrayList<Vaga>();
		pontosPassagem = new HashSet<PontoPassagem>();
	}
	
	public Carona(String pontoPartida, int numeroVagas, Date horario, Date tempoTolerancia, Usuario usuario) {
		this(null, pontoPartida, numeroVagas,horario, tempoTolerancia, usuario);
	}
	
	public void inscreverVaga(Vaga vaga){
		//Duas vagas podem ser iguais
		boolean temVagaDisponivel = numeroVagas < vagas.size();
		if(temVagaDisponivel){
			vagas.add(vaga);
		}
	}
	
	public void inscreverPontoPassagem(PontoPassagem pontoPassagem){
		//Se 2 PP forem iguais, é inútil, tem que ser um set
		pontosPassagem.add(pontoPassagem);
	}
	
	public Integer getId() {
		return id;
	}

	public String getPontoPartida() {
		return pontoPartida;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public int getNumeroVagas() {
		return numeroVagas;
	}

	public Date getHorario() {
		return horario;
	}

	public Date getTempoTolerancia() {
		return tempoTolerancia;
	}

	@Override
	public String toString() {
		return "Carona [id=" + id + ", pontoPartida=" + pontoPartida + ", numeroVagas=" + numeroVagas + ", horario="
				+ horario + ", tempoTolerancia=" + tempoTolerancia + ", usuario=" + usuario + ", vagas=" + vagas
				+ ", pontosPassagem=" + pontosPassagem + "]";
	}	
}