package mb.amazul.siscad.model;

import java.io.Serializable;


public class Ta_emissoresdocumentos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2993438884243855601L;
	
	private Long handle;
	private String nome;
	private Integer pais;
	private Integer estado;
	private String sigla;
	
	
	
	public Ta_emissoresdocumentos() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Ta_emissoresdocumentos(Long handle, String nome, Integer pais, Integer estado, String sigla) {
		super();
		this.handle = handle;
		this.nome = nome;
		this.pais = pais;
		this.estado = estado;
		this.sigla = sigla;
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
	public Integer getPais() {
		return pais;
	}
	public void setPais(Integer pais) {
		this.pais = pais;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	
	

}
