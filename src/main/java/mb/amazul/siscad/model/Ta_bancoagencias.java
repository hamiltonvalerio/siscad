package mb.amazul.siscad.model;

import java.io.Serializable;


public class Ta_bancoagencias implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 62072289634648551L;

	
	private Long handle;
	private Integer banco;
	private String nome;
	private String digito;
	private String codigo;
	private String logradouro;
	private String bairro;
	private String complemento;
	private Integer estado;
	private Integer municipio;
	private String cep;
	private String codigoagencia;
	
	public Ta_bancoagencias() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ta_bancoagencias(Long handle, Integer banco, String nome, String digito, String codigo, String logradouro,
			String bairro, String complemento, Integer estado, Integer municipio, String cep, String codigoagencia) {
		super();
		this.handle = handle;
		this.banco = banco;
		this.nome = nome;
		this.digito = digito;
		this.codigo = codigo;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.complemento = complemento;
		this.estado = estado;
		this.municipio = municipio;
		this.cep = cep;
		this.codigoagencia = codigoagencia;
	}
	public Long getHandle() {
		return handle;
	}
	public void setHandle(Long handle) {
		this.handle = handle;
	}
	public Integer getBanco() {
		return banco;
	}
	public void setBanco(Integer banco) {
		this.banco = banco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDigito() {
		return digito;
	}
	public void setDigito(String digito) {
		this.digito = digito;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	public Integer getMunicipio() {
		return municipio;
	}
	public void setMunicipio(Integer municipio) {
		this.municipio = municipio;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getCodigoagencia() {
		return codigoagencia;
	}
	public void setCodigoagencia(String codigoagencia) {
		this.codigoagencia = codigoagencia;
	}
	
	
}
