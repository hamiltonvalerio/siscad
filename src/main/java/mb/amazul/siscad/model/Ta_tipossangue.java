package mb.amazul.siscad.model;

import java.io.Serializable;

public class Ta_tipossangue implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6407922899562996603L;

	private Long handle;
	private String nome;

	
	
	public Ta_tipossangue() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ta_tipossangue(Long handle, String nome) {
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
