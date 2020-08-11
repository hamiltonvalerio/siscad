package mb.amazul.siscad.model;

import java.io.Serializable;

public class Ta_bancos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -56727895074947836L;


	private Long handle;
	private Integer codigo; 
	private String nome;
	
	
	
	public Ta_bancos() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ta_bancos(Long handle, Integer codigo, String nome) {
		super();
		this.handle = handle;
		this.codigo = codigo;
		this.nome = nome;
	}
	public Long getHandle() {
		return handle;
	}
	public void setHandle(Long handle) {
		this.handle = handle;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
