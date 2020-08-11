package mb.amazul.siscad.model;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import mb.amazul.siscad.model.wrapper.ArquivoContainer;

@Entity
@Table(name = "empregado")
@DynamicUpdate
public class Empregado implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5614288989319665329L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "nomesocial")
	private String nomesocial;

	@Column(name = "datanasc")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date datanasc;

	@Column(name = "estados")
	private Integer estados;

	@Column(name = "nomeestadosnasc")
	private String nomeestadosnasc;

	@Column(name = "munnasc")
	private Integer munnasc;

	@Column(name = "nomemunnasc")
	private String nomemunnasc;

	@Column(name = "rgemp")
	private String rgemp;

	@Column(name = "rgemissoremp")
	private Integer rgemissoremp;

	@Column(name = "rgemissorempnovo")
	private String rgemissorempnovo;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "estadocivil")
	private Integer estadosCivis;

	@Column(name = "nomeestadocivil")
	private String nomeestadocivil;

	@Column(name = "religiao")
	private Integer religiao;

	@Column(name = "nomereligiao")
	private String nomereligiao;

	@Column(name = "sexoemp")
	private String sexoemp;

	@Column(name = "racacor")
	private Integer racaCor;

	@Column(name = "nomeracacor")
	private String nomeracacor;

	@Column(name = "tpsang")
	private Integer tiposSanguineos;

	@Column(name = "nometpsang")
	private String nometpsang;

	@Column(name = "aposentado")
	private String aposentado;

	@Column(name = "naturezaap")
	private Integer naturezaap;

	@Column(name = "nomenaturezaap")
	private String nomenaturezaap;

	@Column(name = "nbap")
	private String nbap;

	@Column(name = "email")
	private String email;

	@Column(name = "telres")
	private String telres;

	@Column(name = "telcel")
	private String telcel;

	@Column(name = "telrec")
	private String telrec;

	@Column(name = "cepres")
	private String cepres;

	@Column(name = "estadosres")
	private Integer estadosres;

	@Column(name = "nomeestadosres")
	private String nomeestadosres;

	@Column(name = "munres")
	private Integer munres;

	@Column(name = "nomemunres")
	private String nomemunres;

	@Column(name = "enderecores")
	private String enderecores;

	@Column(name = "numerores")
	private Integer numerores;

	@Column(name = "bairrores")
	private String bairrores;

	@Column(name = "nivelescolaridade")
	private Integer nivelescolaridade;

	@Column(name = "nomenivelescolaridade")
	private String nomenivelescolaridade;

	@Transient
	private String titulacaores;

	@Transient
	private Integer dataconclusaoemp;

	@Transient
	private Integer curso;

	@Transient
	private String cursoemp;

	@Transient
	private Integer instensinosupemp;

	@Transient
	private String nomeinstensinosupemp;

	@Transient
	private String instensinonovo;

	@Transient
	private String siglanovo;

	@Transient
	private String redenovo;

	@Transient
	private Integer grausensino;

	@Transient
	private String grausensinonome;

	@Transient
	private Integer areasconhecimento;

	@Transient
	private String areasconhecimentonome;

	@Transient
	private String nomcompdpemp;

	@Transient
	private String graupardpemp;

	@Transient
	private String cpfdpemp;

	@Transient
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dtnascdpemp;

	@Transient
	private String nmaedpemp;

	@Transient
	private String depirdpemp;

	@Transient
	private String nomecurso;

	@Column(name = "numconta")
	private String numconta;

	@Column(name = "digconta")
	private String digconta;

	@Column(name = "numagencia")
	private String numagencia;

	@Column(name = "digagencia")
	private String digagencia;

	@Column(name = "bancocontaemp")
	private Integer bancocontaemp;

	@Column(name = "banconovoemp")
	private String banconovoemp;

	@Column(name = "ufag")
	private Integer ufag;

	@Column(name = "nomeufag")
	private String nomeufag;

	@Column(name = "munag")
	private Integer munag;

	@Column(name = "nomemunag")
	private String nomemunag;

	@Column(name = "endagencia")
	private String endagencia;

	@Column(name = "numendagencia")
	private Integer numendagencia;

	@Column(name = "bairroagencia")
	private String bairroagencia;

	@Column(name = "nomeagencia")
	private String nomeagencia;

	@Column(name = "cepagencia")
	private String cepagencia;

	@Column(name = "cpnumero")
	private String cpnumero;

	@Column(name = "cpserie")
	private String cpserie;

	@Column(name = "cpemissor")
	private Integer cpemissor;
	
	@Column(name = "cpemissorempnovo")
	private String cpemissorempnovo;
	
	@Column(name = "numpispasep")
	private String numpispasep;
	
	@Column(name = "numtiteleitor")
	private String numtiteleitor;
	
	@Column(name = "nomedamae")
	private String nomedamae;
	
	@Column(name = "numreservista")
	private String numreservista;

	@Transient
	private ArquivoContainer arquivoContainer;

	@Transient
	private MultipartFile file;

	@OneToMany(targetEntity = Cs_Cargos.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
	@JoinColumn(name = "empregado_id", nullable = false, updatable = false)
	private List<Cs_Cargos> cs_Cargos;

	@OneToMany(targetEntity = Adm_Unidades.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
	@JoinColumn(name = "empregado_id", nullable = false, updatable = false)
	private List<Adm_Unidades> adm_Unidades;

	@OneToMany(targetEntity = Adm_Hierarquias.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
	@JoinColumn(name = "empregado_id", nullable = false, updatable = false)
	private List<Adm_Hierarquias> adm_Hierarquias;

	@OneToMany(targetEntity = Cs_Classes.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
	@JoinColumn(name = "empregado_id", nullable = false, updatable = false)
	private List<Cs_Classes> cs_Classes;

	@OneToMany(targetEntity = Fp_Turnos.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
	@JoinColumn(name = "empregado_id", nullable = false, updatable = false)
	private List<Fp_Turnos> fp_Turnos;

	@Column(name = "datalt")
	private Date datalt;

	@Column(name = "usualt")
	private String usualt;

	@Transient
	private String usuAtivo;

	@Transient
	private Long idUsu;

	@Transient
	private String fotoPerfil;

	@Column(name = "finalizadoexterno", columnDefinition = "boolean default false")
	private Boolean finalizadoexterno;

	@Column(name = "excluido", columnDefinition = "boolean default false")
	private Boolean excluido;

	@Transient
	private String cursoexiste;

	

	

	public Empregado(Long id, String nome, String nomesocial, Date datanasc, Integer estados, String nomeestadosnasc,
			Integer munnasc, String nomemunnasc, String rgemp, Integer rgemissoremp, String rgemissorempnovo,
			String cpf, Integer estadosCivis, String nomeestadocivil, Integer religiao, String nomereligiao,
			String sexoemp, Integer racaCor, String nomeracacor, Integer tiposSanguineos, String nometpsang,
			String aposentado, Integer naturezaap, String nomenaturezaap, String nbap, String email, String telres,
			String telcel, String telrec, String cepres, Integer estadosres, String nomeestadosres, Integer munres,
			String nomemunres, String enderecores, Integer numerores, String bairrores, Integer nivelescolaridade,
			String nomenivelescolaridade, String titulacaores, Integer dataconclusaoemp, Integer curso, String cursoemp,
			Integer instensinosupemp, String nomeinstensinosupemp, String instensinonovo, String siglanovo,
			String redenovo, Integer grausensino, String grausensinonome, Integer areasconhecimento,
			String areasconhecimentonome, String nomcompdpemp, String graupardpemp, String cpfdpemp, Date dtnascdpemp,
			String nmaedpemp, String depirdpemp, String nomecurso, String numconta, String digconta, String numagencia,
			String digagencia, Integer bancocontaemp, String banconovoemp, Integer ufag, String nomeufag, Integer munag,
			String nomemunag, String endagencia, Integer numendagencia, String bairroagencia, String nomeagencia,
			String cepagencia, String cpnumero, String cpserie, Integer cpemissor, String cpemissorempnovo,
			String numpispasep, String numtiteleitor, String nomedamae, String numreservista,
			ArquivoContainer arquivoContainer, MultipartFile file, List<Cs_Cargos> cs_Cargos,
			List<Adm_Unidades> adm_Unidades, List<Adm_Hierarquias> adm_Hierarquias, List<Cs_Classes> cs_Classes,
			List<Fp_Turnos> fp_Turnos, Date datalt, String usualt, String usuAtivo, Long idUsu, String fotoPerfil,
			Boolean finalizadoexterno, Boolean excluido, String cursoexiste) {
		super();
		this.id = id;
		this.nome = nome;
		this.nomesocial = nomesocial;
		this.datanasc = datanasc;
		this.estados = estados;
		this.nomeestadosnasc = nomeestadosnasc;
		this.munnasc = munnasc;
		this.nomemunnasc = nomemunnasc;
		this.rgemp = rgemp;
		this.rgemissoremp = rgemissoremp;
		this.rgemissorempnovo = rgemissorempnovo;
		this.cpf = cpf;
		this.estadosCivis = estadosCivis;
		this.nomeestadocivil = nomeestadocivil;
		this.religiao = religiao;
		this.nomereligiao = nomereligiao;
		this.sexoemp = sexoemp;
		this.racaCor = racaCor;
		this.nomeracacor = nomeracacor;
		this.tiposSanguineos = tiposSanguineos;
		this.nometpsang = nometpsang;
		this.aposentado = aposentado;
		this.naturezaap = naturezaap;
		this.nomenaturezaap = nomenaturezaap;
		this.nbap = nbap;
		this.email = email;
		this.telres = telres;
		this.telcel = telcel;
		this.telrec = telrec;
		this.cepres = cepres;
		this.estadosres = estadosres;
		this.nomeestadosres = nomeestadosres;
		this.munres = munres;
		this.nomemunres = nomemunres;
		this.enderecores = enderecores;
		this.numerores = numerores;
		this.bairrores = bairrores;
		this.nivelescolaridade = nivelescolaridade;
		this.nomenivelescolaridade = nomenivelescolaridade;
		this.titulacaores = titulacaores;
		this.dataconclusaoemp = dataconclusaoemp;
		this.curso = curso;
		this.cursoemp = cursoemp;
		this.instensinosupemp = instensinosupemp;
		this.nomeinstensinosupemp = nomeinstensinosupemp;
		this.instensinonovo = instensinonovo;
		this.siglanovo = siglanovo;
		this.redenovo = redenovo;
		this.grausensino = grausensino;
		this.grausensinonome = grausensinonome;
		this.areasconhecimento = areasconhecimento;
		this.areasconhecimentonome = areasconhecimentonome;
		this.nomcompdpemp = nomcompdpemp;
		this.graupardpemp = graupardpemp;
		this.cpfdpemp = cpfdpemp;
		this.dtnascdpemp = dtnascdpemp;
		this.nmaedpemp = nmaedpemp;
		this.depirdpemp = depirdpemp;
		this.nomecurso = nomecurso;
		this.numconta = numconta;
		this.digconta = digconta;
		this.numagencia = numagencia;
		this.digagencia = digagencia;
		this.bancocontaemp = bancocontaemp;
		this.banconovoemp = banconovoemp;
		this.ufag = ufag;
		this.nomeufag = nomeufag;
		this.munag = munag;
		this.nomemunag = nomemunag;
		this.endagencia = endagencia;
		this.numendagencia = numendagencia;
		this.bairroagencia = bairroagencia;
		this.nomeagencia = nomeagencia;
		this.cepagencia = cepagencia;
		this.cpnumero = cpnumero;
		this.cpserie = cpserie;
		this.cpemissor = cpemissor;
		this.cpemissorempnovo = cpemissorempnovo;
		this.numpispasep = numpispasep;
		this.numtiteleitor = numtiteleitor;
		this.nomedamae = nomedamae;
		this.numreservista = numreservista;
		this.arquivoContainer = arquivoContainer;
		this.file = file;
		this.cs_Cargos = cs_Cargos;
		this.adm_Unidades = adm_Unidades;
		this.adm_Hierarquias = adm_Hierarquias;
		this.cs_Classes = cs_Classes;
		this.fp_Turnos = fp_Turnos;
		this.datalt = datalt;
		this.usualt = usualt;
		this.usuAtivo = usuAtivo;
		this.idUsu = idUsu;
		this.fotoPerfil = fotoPerfil;
		this.finalizadoexterno = finalizadoexterno;
		this.excluido = excluido;
		this.cursoexiste = cursoexiste;
	}

	public Empregado clone() throws CloneNotSupportedException {
		return (Empregado) super.clone();
	}

	public Empregado() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf.replaceAll("[^0-9]", "");
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Cs_Cargos> getCs_Cargos() {
		return cs_Cargos;
	}

	public void setCs_Cargos(List<Cs_Cargos> cs_Cargos) {
		this.cs_Cargos = cs_Cargos;
	}

	public List<Adm_Unidades> getAdm_Unidades() {
		return adm_Unidades;
	}

	public void setAdm_Unidades(List<Adm_Unidades> adm_Unidades) {
		this.adm_Unidades = adm_Unidades;
	}

	public List<Adm_Hierarquias> getAdm_Hierarquias() {
		return adm_Hierarquias;
	}

	public void setAdm_Hierarquias(List<Adm_Hierarquias> adm_Hierarquias) {
		this.adm_Hierarquias = adm_Hierarquias;
	}

	public List<Cs_Classes> getCs_Classes() {
		return cs_Classes;
	}

	public void setCs_Classes(List<Cs_Classes> cs_Classes) {
		this.cs_Classes = cs_Classes;
	}

	public List<Fp_Turnos> getFp_Turnos() {
		return fp_Turnos;
	}

	public void setFp_Turnos(List<Fp_Turnos> fp_Turnos) {
		this.fp_Turnos = fp_Turnos;
	}

	public Date getDatalt() {
		return datalt;
	}

	public void setDatalt(Date datalt) {
		this.datalt = datalt;
	}

	public String getUsualt() {
		return usualt;
	}

	public void setUsualt(String usualt) {
		this.usualt = usualt;
	}

	public Double getPorcentagemConcluida() throws IllegalArgumentException, IllegalAccessException {
		int count = 0;
		for (Field f : this.getClass().getDeclaredFields()) {
			if (f.getType().toString().equals("interface java.util.List")) {
				Object fieldVal = f.get(this);
				List<?> arrayListField = (List<?>) fieldVal;
				if (arrayListField.size() > 0) {
					count++;
				}
			} else if (f.get(this) != null) {
				count++;
			}
		}

		return (double) ((count * 100) / this.getClass().getDeclaredFields().length);
	}

	public String getUsuAtivo() {
		return usuAtivo;
	}

	public void setUsuAtivo(String usuAtivo) {
		this.usuAtivo = usuAtivo;
	}

	public Long getIdUsu() {
		return idUsu;
	}

	public void setIdUsu(Long idUsu) {
		this.idUsu = idUsu;
	}

	public Integer getEstados() {
		return estados;
	}

	public void setEstados(Integer estados) {
		this.estados = estados;
	}

	public Date getDatanasc() {
		return datanasc;
	}

	public void setDatanasc(Date datanasc) {
		this.datanasc = datanasc;
	}

	public String getRgemp() {
		return rgemp;
	}

	public void setRgemp(String rgemp) {
		this.rgemp = rgemp;
	}

	public String getNomesocial() {
		return nomesocial;
	}

	public void setNomesocial(String nomesocial) {
		this.nomesocial = nomesocial;
	}

	public String getSexoemp() {
		return sexoemp;
	}

	public void setSexoemp(String sexoemp) {
		this.sexoemp = sexoemp;
	}

	public String getAposentado() {
		return aposentado;
	}

	public void setAposentado(String aposentado) {
		this.aposentado = aposentado;
	}

	public String getNbap() {
		return nbap;
	}

	public void setNbap(String nbap) {
		this.nbap = nbap;
	}

	public String getTelres() {
		return telres;
	}

	public void setTelres(String telres) {
		this.telres = telres;
	}

	public String getTelcel() {
		return telcel;
	}

	public void setTelcel(String telcel) {
		this.telcel = telcel;
	}

	public String getTelrec() {
		return telrec;
	}

	public void setTelrec(String telrec) {
		this.telrec = telrec;
	}

	public String getCepres() {
		return cepres;
	}

	public void setCepres(String cepres) {
		this.cepres = cepres;
	}

	public String getEnderecores() {
		return enderecores;
	}

	public void setEnderecores(String enderecores) {
		this.enderecores = enderecores;
	}

	public String getBairrores() {
		return bairrores;
	}

	public void setBairrores(String bairrores) {
		this.bairrores = bairrores;
	}

	public Integer getEstadosCivis() {
		return estadosCivis;
	}

	public void setEstadosCivis(Integer estadosCivis) {
		this.estadosCivis = estadosCivis;
	}

	public Integer getRacaCor() {
		return racaCor;
	}

	public void setRacaCor(Integer racaCor) {
		this.racaCor = racaCor;
	}

	public Integer getTiposSanguineos() {
		return tiposSanguineos;
	}

	public void setTiposSanguineos(Integer tiposSanguineos) {
		this.tiposSanguineos = tiposSanguineos;
	}

	public Integer getEstadosres() {
		return estadosres;
	}

	public void setEstadosres(Integer estadosres) {
		this.estadosres = estadosres;
	}

	public Integer getMunnasc() {
		return munnasc;
	}

	public void setMunnasc(Integer munnasc) {
		this.munnasc = munnasc;
	}

	public Integer getMunres() {
		return munres;
	}

	public void setMunres(Integer munres) {
		this.munres = munres;
	}

	public String getTitulacaores() {
		return titulacaores;
	}

	public void setTitulacaores(String titulacaores) {
		this.titulacaores = titulacaores;
	}

	public String getCursoemp() {
		return cursoemp;
	}

	public void setCursoemp(String cursoemp) {
		this.cursoemp = cursoemp;
	}

	public String getInstensinonovo() {
		return instensinonovo;
	}

	public void setInstensinonovo(String instensinonovo) {
		this.instensinonovo = instensinonovo;
	}

	public String getSiglanovo() {
		return siglanovo;
	}

	public void setSiglanovo(String siglanovo) {
		this.siglanovo = siglanovo;
	}

	public String getRedenovo() {
		return redenovo;
	}

	public void setRedenovo(String redenovo) {
		this.redenovo = redenovo;
	}

	public String getNomcompdpemp() {
		return nomcompdpemp;
	}

	public void setNomcompdpemp(String nomcompdpemp) {
		this.nomcompdpemp = nomcompdpemp;
	}

	public String getGraupardpemp() {
		return graupardpemp;
	}

	public void setGraupardpemp(String graupardpemp) {
		this.graupardpemp = graupardpemp;
	}

	public String getCpfdpemp() {
		return cpfdpemp;
	}

	public void setCpfdpemp(String cpfdpemp) {
		this.cpfdpemp = cpfdpemp;
	}

	public Date getDtnascdpemp() {
		return dtnascdpemp;
	}

	public void setDtnascdpemp(Date dtnascdpemp) {
		this.dtnascdpemp = dtnascdpemp;
	}

	public String getNmaedpemp() {
		return nmaedpemp;
	}

	public void setNmaedpemp(String nmaedpemp) {
		this.nmaedpemp = nmaedpemp;
	}

	public String getDepirdpemp() {
		return depirdpemp;
	}

	public void setDepirdpemp(String depirdpemp) {
		this.depirdpemp = depirdpemp;
	}

	public String getNumconta() {
		return numconta;
	}

	public void setNumconta(String numconta) {
		this.numconta = numconta;
	}

	public String getDigconta() {
		return digconta;
	}

	public void setDigconta(String digconta) {
		this.digconta = digconta;
	}

	public String getNumagencia() {
		return numagencia;
	}

	public void setNumagencia(String numagencia) {
		this.numagencia = numagencia;
	}

	public String getDigagencia() {
		return digagencia;
	}

	public void setDigagencia(String digagencia) {
		this.digagencia = digagencia;
	}

	public Integer getUfag() {
		return ufag;
	}

	public void setUfag(Integer ufag) {
		this.ufag = ufag;
	}

	public Integer getMunag() {
		return munag;
	}

	public void setMunag(Integer munag) {
		this.munag = munag;
	}

	public String getEndagencia() {
		return endagencia;
	}

	public void setEndagencia(String endagencia) {
		this.endagencia = endagencia;
	}

	public Integer getNumendagencia() {
		return numendagencia;
	}

	public void setNumendagencia(Integer numendagencia) {
		this.numendagencia = numendagencia;
	}

	public String getBairroagencia() {
		return bairroagencia;
	}

	public void setBairroagencia(String bairroagencia) {
		this.bairroagencia = bairroagencia;
	}

	public String getNomeagencia() {
		return nomeagencia;
	}

	public void setNomeagencia(String nomeagencia) {
		this.nomeagencia = nomeagencia;
	}

	public String getCepagencia() {
		return cepagencia;
	}

	public void setCepagencia(String cepagencia) {
		this.cepagencia = cepagencia;
	}

	public ArquivoContainer getArquivoContainer() {
		return arquivoContainer;
	}

	public void setArquivoContainer(ArquivoContainer arquivoContainer) {
		this.arquivoContainer = arquivoContainer;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public Integer getNumerores() {
		return numerores;
	}

	public void setNumerores(Integer numerores) {
		this.numerores = numerores;
	}

	public String getNomeestadosnasc() {
		return nomeestadosnasc;
	}

	public void setNomeestadosnasc(String nomeestadosnasc) {
		this.nomeestadosnasc = nomeestadosnasc;
	}

	public String getNomemunnasc() {
		return nomemunnasc;
	}

	public void setNomemunnasc(String nomemunnasc) {
		this.nomemunnasc = nomemunnasc;
	}

	public String getNomeestadosres() {
		return nomeestadosres;
	}

	public void setNomeestadosres(String nomeestadosres) {
		this.nomeestadosres = nomeestadosres;
	}

	public String getNomemunres() {
		return nomemunres;
	}

	public void setNomemunres(String nomemunres) {
		this.nomemunres = nomemunres;
	}

	public String getNomeufag() {
		return nomeufag;
	}

	public void setNomeufag(String nomeufag) {
		this.nomeufag = nomeufag;
	}

	public String getNomemunag() {
		return nomemunag;
	}

	public void setNomemunag(String nomemunag) {
		this.nomemunag = nomemunag;
	}

	public Integer getRgemissoremp() {
		return rgemissoremp;
	}

	public void setRgemissoremp(Integer rgemissoremp) {
		this.rgemissoremp = rgemissoremp;
	}

	public String getRgemissorempnovo() {
		return rgemissorempnovo;
	}

	public void setRgemissorempnovo(String rgemissorempnovo) {
		this.rgemissorempnovo = rgemissorempnovo;
	}

	public Integer getReligiao() {
		return religiao;
	}

	public void setReligiao(Integer religiao) {
		this.religiao = religiao;
	}

	public Integer getNaturezaap() {
		return naturezaap;
	}

	public void setNaturezaap(Integer naturezaap) {
		this.naturezaap = naturezaap;
	}

	public Integer getNivelescolaridade() {
		return nivelescolaridade;
	}

	public void setNivelescolaridade(Integer nivelescolaridade) {
		this.nivelescolaridade = nivelescolaridade;
	}

	public Integer getDataconclusaoemp() {
		return dataconclusaoemp;
	}

	public void setDataconclusaoemp(Integer dataconclusaoemp) {
		this.dataconclusaoemp = dataconclusaoemp;
	}

	public Integer getCurso() {
		return curso;
	}

	public void setCurso(Integer curso) {
		this.curso = curso;
	}

	public Integer getBancocontaemp() {
		return bancocontaemp;
	}

	public void setBancocontaemp(Integer bancocontaemp) {
		this.bancocontaemp = bancocontaemp;
	}

	public String getBanconovoemp() {
		return banconovoemp;
	}

	public void setBanconovoemp(String banconovoemp) {
		this.banconovoemp = banconovoemp;
	}

	public String getNomecurso() {
		return nomecurso;
	}

	public void setNomecurso(String nomecurso) {
		this.nomecurso = nomecurso;
	}

	public String getFotoPerfil() {
		return fotoPerfil;
	}

	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}

	public String getNomeestadocivil() {
		return nomeestadocivil;
	}

	public void setNomeestadocivil(String nomeestadocivil) {
		this.nomeestadocivil = nomeestadocivil;
	}

	public String getNomereligiao() {
		return nomereligiao;
	}

	public void setNomereligiao(String nomereligiao) {
		this.nomereligiao = nomereligiao;
	}

	public String getNomeracacor() {
		return nomeracacor;
	}

	public void setNomeracacor(String nomeracacor) {
		this.nomeracacor = nomeracacor;
	}

	public String getNometpsang() {
		return nometpsang;
	}

	public void setNometpsang(String nometpsang) {
		this.nometpsang = nometpsang;
	}

	public String getNomenaturezaap() {
		return nomenaturezaap;
	}

	public void setNomenaturezaap(String nomenaturezaap) {
		this.nomenaturezaap = nomenaturezaap;
	}

	public String getNomenivelescolaridade() {
		return nomenivelescolaridade;
	}

	public void setNomenivelescolaridade(String nomenivelescolaridade) {
		this.nomenivelescolaridade = nomenivelescolaridade;
	}

	public Integer getInstensinosupemp() {
		return instensinosupemp;
	}

	public void setInstensinosupemp(Integer instensinosupemp) {
		this.instensinosupemp = instensinosupemp;
	}

	public String getNomeinstensinosupemp() {
		return nomeinstensinosupemp;
	}

	public void setNomeinstensinosupemp(String nomeinstensinosupemp) {
		this.nomeinstensinosupemp = nomeinstensinosupemp;
	}

	public Integer getGrausensino() {
		return grausensino;
	}

	public void setGrausensino(Integer grausensino) {
		this.grausensino = grausensino;
	}

	public String getGrausensinonome() {
		return grausensinonome;
	}

	public void setGrausensinonome(String grausensinonome) {
		this.grausensinonome = grausensinonome;
	}

	public Integer getAreasconhecimento() {
		return areasconhecimento;
	}

	public void setAreasconhecimento(Integer areasconhecimento) {
		this.areasconhecimento = areasconhecimento;
	}

	public String getAreasconhecimentonome() {
		return areasconhecimentonome;
	}

	public void setAreasconhecimentonome(String areasconhecimentonome) {
		this.areasconhecimentonome = areasconhecimentonome;
	}

	public Boolean getFinalizadoexterno() {
		return finalizadoexterno;
	}

	public void setFinalizadoexterno(Boolean finalizadoexterno) {
		this.finalizadoexterno = finalizadoexterno;
	}

	public Boolean getExcluido() {
		return excluido;
	}

	public void setExcluido(Boolean excluido) {
		this.excluido = excluido;
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

	@Transient
	public String getBooleanFoto() {
		if (this.getFotoPerfil() != null) {
			return "true";
		} else {
			return "false";
		}
	}

	@Transient
	public String getBooleanFotoFixa() {
		if (this.getFotoPerfil() != null) {
			return "false";
		} else {
			return "true";
		}
	}

	public String getCpemissorempnovo() {
		return cpemissorempnovo;
	}

	public void setCpemissorempnovo(String cpemissorempnovo) {
		this.cpemissorempnovo = cpemissorempnovo;
	}

	public String getNumpispasep() {
		return numpispasep;
	}

	public void setNumpispasep(String numpispasep) {
		this.numpispasep = numpispasep;
	}

	public String getNumtiteleitor() {
		return numtiteleitor;
	}

	public void setNumtiteleitor(String numtiteleitor) {
		this.numtiteleitor = numtiteleitor;
	}

	public String getNomedamae() {
		return nomedamae;
	}

	public void setNomedamae(String nomedamae) {
		this.nomedamae = nomedamae;
	}

	public String getNumreservista() {
		return numreservista;
	}

	public void setNumreservista(String numreservista) {
		this.numreservista = numreservista;
	}

	public String getCursoexiste() {
		return cursoexiste;
	}

	public void setCursoexiste(String cursoexiste) {
		this.cursoexiste = cursoexiste;
	}
	
	

}
