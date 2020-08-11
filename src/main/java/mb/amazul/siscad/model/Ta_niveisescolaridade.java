package mb.amazul.siscad.model;

import java.io.Serializable;

public class Ta_niveisescolaridade implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2808774314833574993L;
	
	private Long Handle;
	private String nome;
	private Integer k_codamazulprev;
	
	
	
	public Ta_niveisescolaridade() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ta_niveisescolaridade(Long handle, String nome, Integer k_codamazulprev) {
		super();
		Handle = handle;
		this.nome = nome;
		this.k_codamazulprev = k_codamazulprev;
	}
	public Long getHandle() {
		return Handle;
	}
	public void setHandle(Long handle) {
		Handle = handle;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getK_codamazulprev() {
		return k_codamazulprev;
	}
	public void setK_codamazulprev(Integer k_codamazulprev) {
		this.k_codamazulprev = k_codamazulprev;
	}
	
	
	
}
