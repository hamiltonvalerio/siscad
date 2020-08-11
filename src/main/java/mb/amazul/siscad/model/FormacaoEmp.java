package mb.amazul.siscad.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name = "formacaoemp")
@Table(name = "formacaoemp")
public class FormacaoEmp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3874206079636399109L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "titulacao")
	private String titulacao;

	@Column(name = "anoconclusao")
	private Integer anoconclusao;

	@Column(name = "curso")
	private Integer curso;

	@Column(name = "cursoemp")
	private String cursoemp;

	@Column(name = "instensinosup")
	private Integer instensinosup;

	@Column(name = "nomeinstensinosup")
	private String nomeinstensinosup;

	@Column(name = "grausensino")
	private Integer grausensino;

	@Column(name = "grausensinonome")
	private String grausensinonome;

	@Column(name = "areasconhecimento")
	private Integer areasconhecimento;

	@Column(name = "areasconhecimentonome")
	private String areasconhecimentonome;

	@ManyToOne
	@JoinColumn(name = "empregado_id", nullable = false)
	private Empregado empregado;

	@Column(name = "datalt")
	private Date datalt;

	@Column(name = "usualt")
	private String usualt;

	@Transient
	private Boolean finalizadoexterno;

	public FormacaoEmp(Long id, String titulacao, Integer anoconclusao, Integer curso, String cursoemp,
			Integer instensinosup, String nomeinstensinosup, Integer grausensino, String grausensinonome,
			Integer areasconhecimento, String areasconhecimentonome, Empregado empregado, Date datalt, String usualt,
			Boolean finalizadoexterno) {
		super();
		this.id = id;
		this.titulacao = titulacao;
		this.anoconclusao = anoconclusao;
		this.curso = curso;
		this.cursoemp = cursoemp;
		this.instensinosup = instensinosup;
		this.nomeinstensinosup = nomeinstensinosup;
		this.grausensino = grausensino;
		this.grausensinonome = grausensinonome;
		this.areasconhecimento = areasconhecimento;
		this.areasconhecimentonome = areasconhecimentonome;
		this.empregado = empregado;
		this.datalt = datalt;
		this.usualt = usualt;
		this.finalizadoexterno = finalizadoexterno;
	}

	public String getNomeinstensinosup() {
		return nomeinstensinosup;
	}

	public void setNomeinstensinosup(String nomeinstensinosup) {
		this.nomeinstensinosup = nomeinstensinosup;
	}

	public void setInstensinosup(Integer instensinosup) {
		this.instensinosup = instensinosup;
	}

	public FormacaoEmp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}

	public Empregado getEmpregado() {
		return empregado;
	}

	public void setEmpregado(Empregado empregado) {
		this.empregado = empregado;
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

	public Integer getAnoconclusao() {
		return anoconclusao;
	}

	public void setAnoconclusao(Integer anoconclusao) {
		this.anoconclusao = anoconclusao;
	}

	public Integer getCurso() {
		return curso;
	}

	public void setCurso(Integer curso) {
		this.curso = curso;
	}

	public String getCursoemp() {
		return cursoemp;
	}

	public void setCursoemp(String cursoemp) {
		this.cursoemp = cursoemp;
	}

	public Integer getInstensinosup() {
		return instensinosup;
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
		if(finalizadoexterno == null) {
			finalizadoexterno = false;
		}
		return finalizadoexterno;
	}

	public void setFinalizadoexterno(Boolean finalizadoexterno) {
		this.finalizadoexterno = finalizadoexterno;
	}

}
