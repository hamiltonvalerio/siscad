package mb.amazul.siscad.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "servidor")
public class Servidor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 750755303859147006L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "ip")
	private String ip;
	
	@Column(name = "descricao")
	private String descricao;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "infra_id_fk")
  	private Infra infra;
	
	@ManyToOne
	@JoinColumn(name = "rack_id_fk")
	private Rack rack;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "status_id_fk")
  	private Status status;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ambiente_id_fk")
	private Ambiente ambiente;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tipo_id_fk")
	private Tipo tipo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "criticidade_id_fk")
	private Criticidade criticidade;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "so_id_fk")
	private So so;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fabricante_id_fk")
	private Fabricante fabricante;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "modelo_id_fk")
	private Modelo modelo;
	
	@Column(name = "datalt")
	private Date datalt;
	
	@Column(name = "usualt")
	private String usualt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Infra getInfra() {
		return infra;
	}

	public void setInfra(Infra infra) {
		this.infra = infra;
	}

	public Rack getRack() {
		return rack;
	}

	public void setRack(Rack rack) {
		this.rack = rack;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Ambiente getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Criticidade getCriticidade() {
		return criticidade;
	}

	public void setCriticidade(Criticidade criticidade) {
		this.criticidade = criticidade;
	}

	public So getSo() {
		return so;
	}

	public void setSo(So so) {
		this.so = so;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public Date getDatalt() {
		return datalt;
	}

	public void setDatalt(Date datalt) {
		this.datalt = datalt;
	}

	public String getUsualt() {
		return usualt;
	}

	public void setUsualt(String usualt) {
		this.usualt = usualt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
 