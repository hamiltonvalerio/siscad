package mb.amazul.siscad.model;

import java.io.Serializable;


import javax.persistence.Id;

public class Do_funcionarios implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5257661461625789305L;

	@Id
	private Long handle;

	private String dataadmissao;
	
	private Integer turno;
	
	private Integer hierarquia;
	
	private Integer pais;
	
	private Integer situacao;

	private Integer k_formatratamento;
	
	private Integer tipocolaborador;
	
	private Integer empresa;
	
	private Integer unidade;
	
	private String nome;
	
	private String datanascimento;
	
	private Integer estado;
	
	private Integer municipio;
	
	private Integer rgnumero;
	
	private Integer rgemissor;
	
	private String cpfnumero;
	
	private Integer estadocivil;
	
	private Integer religiao;
	
	private String sexo;
	
	private Integer racacor;
	
	private Integer tiposangue;
	
	private String email;

	private String cpnumero;
	
	private String cpserie;
	
	private Integer cpemissor;
	
	private String pisnumero;

	private String matricula;
	
	private Integer sindicato;
	
	//ate aqui
	
	private String cargo;
		
	private String concurso;
	
	private String classificacao;
	
	private String nivelescolaridade;
	
	private String k_nipncp;

	public Long getHandle() {
		return handle;
	}

	public void setHandle(Long handle) {
		this.handle = handle;
	}

	public String getDataadmissao() {
		return dataadmissao;
	}

	public void setDataadmissao(String dataadmissao) {
		this.dataadmissao = dataadmissao;
	}

	public Integer getTurno() {
		return turno;
	}

	public void setTurno(Integer turno) {
		this.turno = turno;
	}

	public Integer getHierarquia() {
		return hierarquia;
	}

	public void setHierarquia(Integer hierarquia) {
		this.hierarquia = hierarquia;
	}

	public Integer getPais() {
		return pais;
	}

	public void setPais(Integer pais) {
		this.pais = pais;
	}

	public Integer getSituacao() {
		return situacao;
	}

	public void setSituacao(Integer situacao) {
		this.situacao = situacao;
	}

	public Integer getK_formatratamento() {
		return k_formatratamento;
	}

	public void setK_formatratamento(Integer k_formatratamento) {
		this.k_formatratamento = k_formatratamento;
	}

	public Integer getTipocolaborador() {
		return tipocolaborador;
	}

	public void setTipocolaborador(Integer tipocolaborador) {
		this.tipocolaborador = tipocolaborador;
	}

	public Integer getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Integer empresa) {
		this.empresa = empresa;
	}

	public Integer getUnidade() {
		return unidade;
	}

	public void setUnidade(Integer unidade) {
		this.unidade = unidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(String datanascimento) {
		this.datanascimento = datanascimento;
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

	public Integer getRgnumero() {
		return rgnumero;
	}

	public void setRgnumero(Integer rgnumero) {
		this.rgnumero = rgnumero;
	}

	public Integer getRgemissor() {
		return rgemissor;
	}

	public void setRgemissor(Integer rgemissor) {
		this.rgemissor = rgemissor;
	}

	public String getCpfnumero() {
		return cpfnumero;
	}

	public void setCpfnumero(String cpfnumero) {
		this.cpfnumero = cpfnumero;
	}

	public Integer getEstadocivil() {
		return estadocivil;
	}

	public void setEstadocivil(Integer estadocivil) {
		this.estadocivil = estadocivil;
	}

	public Integer getReligiao() {
		return religiao;
	}

	public void setReligiao(Integer religiao) {
		this.religiao = religiao;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Integer getRacacor() {
		return racacor;
	}

	public void setRacacor(Integer racacor) {
		this.racacor = racacor;
	}

	public Integer getTiposangue() {
		return tiposangue;
	}

	public void setTiposangue(Integer tiposangue) {
		this.tiposangue = tiposangue;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpnumero() {
		return cpnumero;
	}

	public void setCpnumero(String cpnumero) {
		this.cpnumero = cpnumero;
	}

	public String getCpserie() {
		return cpserie;
	}

	public void setCpserie(String cpserie) {
		this.cpserie = cpserie;
	}

	public Integer getCpemissor() {
		return cpemissor;
	}

	public void setCpemissor(Integer cpemissor) {
		this.cpemissor = cpemissor;
	}

	public String getPisnumero() {
		return pisnumero;
	}

	public void setPisnumero(String pisnumero) {
		this.pisnumero = pisnumero;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Integer getSindicato() {
		return sindicato;
	}

	public void setSindicato(Integer sindicato) {
		this.sindicato = sindicato;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getConcurso() {
		return concurso;
	}

	public void setConcurso(String concurso) {
		this.concurso = concurso;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public String getNivelescolaridade() {
		return nivelescolaridade;
	}

	public void setNivelescolaridade(String nivelescolaridade) {
		this.nivelescolaridade = nivelescolaridade;
	}

	public String getK_nipncp() {
		return k_nipncp;
	}

	public void setK_nipncp(String k_nipncp) {
		this.k_nipncp = k_nipncp;
	}

	
	
}
