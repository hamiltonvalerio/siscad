package mb.amazul.siscad.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "adm_Hieraquias")
public class Adm_Hierarquias implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7933803091033282841L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private Long handle;
	
	private String nome;
	
	private String estrutura;
	
	
	
	public Adm_Hierarquias(String source) {
		// TODO Auto-generated constructor stub
	}
	
	


	public Adm_Hierarquias(Long id, Long handle, String nome, String estrutura) {
		super();
		this.id = id;
		this.handle = handle;
		this.nome = nome;
		this.estrutura = estrutura;
	}




	public Adm_Hierarquias() {
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
	public String getEstrutura() {
		return estrutura;
	}
	public void setEstrutura(String estrutura) {
		this.estrutura = estrutura;
	}
	public String getEstruturaNome(){
		return getEstrutura()+" - "+getNome();
	}
	
}
