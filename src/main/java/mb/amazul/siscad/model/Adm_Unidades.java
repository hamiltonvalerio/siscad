package mb.amazul.siscad.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "adm_Unidades")
public class Adm_Unidades implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1736983951556244168L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private Long handle;
	
	private String nome;
	
	public Adm_Unidades() {
		
	}

	public Adm_Unidades(Long id, Long handle, String nome) {
		super();
		this.id = id;
		this.handle = handle;
		this.nome = nome;
	}

	public Adm_Unidades(String source) {
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
	
	
}
