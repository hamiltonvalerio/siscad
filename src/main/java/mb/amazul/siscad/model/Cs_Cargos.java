package mb.amazul.siscad.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cs_Cargos")
public class Cs_Cargos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7090775428251962838L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private Long handle;
	
	private String titulo;

	
	

	public Cs_Cargos() {
		
		// TODO Auto-generated constructor stub
	}

	public Cs_Cargos(Long id, Long handle, String titulo) {
		super();
		this.id = id;
		this.handle = handle;
		this.titulo = titulo;
	}

	public Cs_Cargos(String source) {
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

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	
	
	
	

}
