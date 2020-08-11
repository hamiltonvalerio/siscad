package mb.amazul.siscad.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity(name = "marcacaoponto")
@Table(name = "marcacaoponto")
public class MarcacaoPonto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7528913775129773238L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "dia")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dia;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="marcacaoponto_batida", joinColumns=@JoinColumn(name="marcacaoponto_id"), inverseJoinColumns=@JoinColumn(name="batida_id"))
	private List<Batida> batida;

	public MarcacaoPonto(Long id, Date dia, List<Batida> batida) {
		super();
		this.id = id;
		this.dia = dia;
		this.batida = batida;
	}

	public MarcacaoPonto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	public List<Batida> getBatida() {
		return batida;
	}

	public void setBatida(List<Batida> batida) {
		this.batida = batida;
	}
	
	
}
