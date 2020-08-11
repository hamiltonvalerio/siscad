package mb.amazul.siscad.model;

import java.io.Serializable;

public class Fp_raisdesligamentotipos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1888764845011060423L;
	
	private Long handle;
	private Integer codigo;
	private String nome;
	
	public Fp_raisdesligamentotipos() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Fp_raisdesligamentotipos(Long handle, Integer codigo, String nome) {
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
