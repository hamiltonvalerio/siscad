package mb.amazul.siscad.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fp_Turnos")
public class Fp_Turnos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6368442924606280071L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long handle;
	private String nome;
	private String horassemana;
	
	
	
	public Fp_Turnos() {
	
		// TODO Auto-generated constructor stub
	}


	public Fp_Turnos(Long id, Long handle, String nome, String horassemana) {
		super();
		this.id = id;
		this.handle = handle;
		this.nome = nome;
		this.horassemana = horassemana;
	}


	public Fp_Turnos(String source) {
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
	public String getHorassemana() {
		return horassemana;
	}
	public void setHorassemana(String horassemana) {
		this.horassemana = horassemana;
	}
	
	
	
	
}
