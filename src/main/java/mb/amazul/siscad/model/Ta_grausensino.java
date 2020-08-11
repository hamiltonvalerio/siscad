package mb.amazul.siscad.model;

import java.io.Serializable;

import javax.persistence.Id;

public class Ta_grausensino implements Serializable{


	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3097179509192829176L;
	
	@Id
	private Long handle;
	private String nome;
	
	
	
	public Ta_grausensino() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ta_grausensino(Long handle, String nome) {
		super();
		this.handle = handle;
		this.nome = nome;
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
