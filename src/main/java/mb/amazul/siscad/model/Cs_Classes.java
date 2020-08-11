package mb.amazul.siscad.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cs_Classes")
public class Cs_Classes implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3491674174910531245L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private Long handle;
	
	private String nome;
	
	private Integer empresa;
	
	
	

	public Cs_Classes() {
		// TODO Auto-generated constructor stub
	}

	public Cs_Classes(Long id, Long handle, String nome, Integer empresa) {
		super();
		this.id = id;
		this.handle = handle;
		this.nome = nome;
		this.empresa = empresa;
	}

	public Cs_Classes(String source) {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getHandle() {
		return handle;
	}

	public void setHandle(Long handle) {
		this.handle = handle;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Integer empresa) {
		this.empresa = empresa;
	}
	
	
	
}
