package mb.amazul.siscad.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "dependenteemp")
@Table(name = "dependenteemp")
public class DependenteEmp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1692899979670527545L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "nomcompdepen")
	private String nomcompdepen;

	@Column(name = "graupardepen")
	private String graupardepen;

	@Column(name = "cpfdepen")
	private String cpfdepen;

	@Column(name = "dtnascdepen")
	private Date dtnascdepen;

	@Column(name = "nmaedepen")
	private String nmaedepen;

	@Column(name = "depirdepen")
	private String depirdepen;

	@ManyToOne
	@JoinColumn(name = "empregado_id", nullable = false)
	private Empregado empregado;

	@Column(name = "datalt")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date datalt;

	@Column(name = "usualt")
	private String usualt;

	@Transient
	private Boolean finalizadoexterno;

	public DependenteEmp(Long id, String nomcompdepen, String graupardepen, String cpfdepen, Date dtnascdepen,
			String nmaedepen, String depirdepen, Empregado empregado, Date datalt, String usualt,
			Boolean finalizadoexterno) {
		super();
		this.id = id;
		this.nomcompdepen = nomcompdepen;
		this.graupardepen = graupardepen;
		this.cpfdepen = cpfdepen;
		this.dtnascdepen = dtnascdepen;
		this.nmaedepen = nmaedepen;
		this.depirdepen = depirdepen;
		this.empregado = empregado;
		this.datalt = datalt;
		this.usualt = usualt;
		this.finalizadoexterno = finalizadoexterno;
	}

	public DependenteEmp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomcompdepen() {
		return nomcompdepen;
	}

	public void setNomcompdepen(String nomcompdepen) {
		this.nomcompdepen = nomcompdepen;
	}

	public String getGraupardepen() {
		return graupardepen;
	}

	public void setGraupardepen(String graupardepen) {
		this.graupardepen = graupardepen;
	}

	public String getCpfdepen() {
		return cpfdepen;
	}

	public void setCpfdepen(String cpfdepen) {
		this.cpfdepen = cpfdepen;
	}

	public Date getDtnascdepen() {
		return dtnascdepen;
	}

	public void setDtnascdepen(Date dtnascdepen) {
		this.dtnascdepen = dtnascdepen;
	}

	public String getNmaedepen() {
		return nmaedepen;
	}

	public void setNmaedepen(String nmaedepen) {
		this.nmaedepen = nmaedepen;
	}

	public String getDepirdepen() {
		return depirdepen;
	}

	public void setDepirdepen(String depirdepen) {
		this.depirdepen = depirdepen;
	}

	public Empregado getEmpregado() {
		return empregado;
	}

	public void setEmpregado(Empregado empregado) {
		this.empregado = empregado;
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

	public Boolean getFinalizadoexterno() {
		if(finalizadoexterno == null) {
			finalizadoexterno = false;
		}
		return finalizadoexterno;
	}

	public void setFinalizadoexterno(Boolean finalizadoexterno) {
		this.finalizadoexterno = finalizadoexterno;
	}

}
