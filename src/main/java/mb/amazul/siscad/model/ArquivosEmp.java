package mb.amazul.siscad.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "arquivosemp")
@Table(name = "arquivosemp")
public class ArquivosEmp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4945527367600849233L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "nome", length = 100, nullable = false)
	private String nome;

	@Column(name = "descricao", length = 255)
	private String descricao;

	@Column(name = "tipo", length = 100, nullable = false)
	private String tipo;

	@Basic(fetch = FetchType.LAZY)
	@Column(name = "conteudo", nullable = false)
	private byte[] conteudo;

	@ManyToOne
	@JoinColumn(name = "empregado_id", nullable = false)
	private Empregado empregado;

	@Column(name = "datalt")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date datalt;

	@Column(name = "usualt")
	private String usualt;

	@Transient
	private Boolean finalizadoexterno;

	public ArquivosEmp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArquivosEmp(Long id, String nome, String descricao, String tipo, byte[] conteudo, Empregado empregado,
			Date datalt, String usualt, Boolean finalizadoexterno) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.tipo = tipo;
		this.conteudo = conteudo;
		this.empregado = empregado;
		this.datalt = datalt;
		this.usualt = usualt;
		this.finalizadoexterno = finalizadoexterno;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public byte[] getConteudo() {
		return conteudo;
	}

	public void setConteudo(byte[] conteudo) {
		this.conteudo = conteudo;
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

	public Boolean getFinalizadoexterno() {
		if(finalizadoexterno == null) {
			finalizadoexterno = false;
		}
		return finalizadoexterno;
	}

	public void setFinalizadoexterno(Boolean finalizadoexterno) {
		this.finalizadoexterno = finalizadoexterno;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArquivosEmp other = (ArquivosEmp) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ArquivosEmp [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", tipo=" + tipo + "]";
	}

}
