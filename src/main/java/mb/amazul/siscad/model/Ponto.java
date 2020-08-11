package mb.amazul.siscad.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.codec.binary.Base64;
import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "ponto")
@Table(name = "ponto")
public class Ponto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1261982360919531132L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "datainicial")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate datainicial;

	@Column(name = "datafinal")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate datafinal;

	/*
	 * @OneToMany(targetEntity = MarcacaoPonto.class, cascade = CascadeType.ALL,
	 * fetch = FetchType.EAGER)
	 * 
	 * @Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
	 * 
	 * @JoinColumn(name = "ponto_id", nullable = false, updatable = false) private
	 * List<MarcacaoPonto> listaMarcacaoes;
	 */

	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuario;
	
	@Column(name = "tipo")
	private String tipo; 
	
	@Column(name = "hora")
	private LocalTime hora;
	
	@Column(name = "data")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate data;
	
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "foto", nullable = false)
	private byte[] foto;
	
	@Transient
	private String fotoPerfil;
		

	

	public Ponto(Long id, LocalDate datainicial, LocalDate datafinal, Usuario usuario, String tipo, LocalTime hora,
			LocalDate data, byte[] foto, String fotoPerfil) {
		super();
		this.id = id;
		this.datainicial = datainicial;
		this.datafinal = datafinal;
		this.usuario = usuario;
		this.tipo = tipo;
		this.hora = hora;
		this.data = data;
		this.foto = foto;
		this.fotoPerfil = fotoPerfil;
	}

	public Ponto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDatainicial() {
		return datainicial;
	}

	public void setDatainicial(LocalDate datainicial) {
		this.datainicial = datainicial;
	}

	public LocalDate getDatafinal() {
		return datafinal;
	}

	public void setDatafinal(LocalDate datafinal) {
		this.datafinal = datafinal;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getFotoPerfil() {
		if(this.getFoto() != null ) {
			fotoPerfil = Base64.encodeBase64String(this.getFoto());
		}
		return fotoPerfil;
	}

	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}
	
	
	
}
