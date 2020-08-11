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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "so")
public class So implements Serializable{



	/**
	 * 
	 */
	private static final long serialVersionUID = -369958226899575843L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "nome")
	private String nome;

	@Column(name = "datalt")
	private Date datalt;
	
	@Column(name = "usualt")
	private String usualt;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "arquitetura_id_fk")
	private Arquitetura arquitetura;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
