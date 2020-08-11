package mb.amazul.siscad.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name = "usuario")
@Table(name = "usuario")
public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1500046325627034449L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "cpf")
	private String cpf;
	
	@Column(name = "nome")
	private String nome; 
	 
	@Column(name = "password")
	private String password;
	
	@Column(name = "ativo")
	private Integer ativo;
	
	@Column(name = "datalt")
	private Date datalt;
	
	@Column(name = "usualt")
	private String usualt;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="usuario_perfil", joinColumns=@JoinColumn(name="usuario_id"), inverseJoinColumns=@JoinColumn(name="perfil_id"))
	private Set<Perfil> perfis = new HashSet<Perfil>();

	@Transient
	private String passwordConfirm;
	
	@Transient
	private String usuativo;
	
	@Transient
	private String usuIcone;
	
	public Usuario() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAtivo() {
		if(ativo != null) {
			if(ativo == 1) {
				this.usuativo = "ATIVO";
			}else {
				this.usuativo = "INATIVO";
			}
		}
		return ativo;
	}

	public void setAtivo(Integer ativo) {
		this.ativo = ativo;
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

	public Set<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(Set<Perfil> perfis) {
		this.perfis = perfis;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	
	
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getUsuativo() {
		return usuativo;
	}

	public String getUsuIcone() {
		return usuIcone;
	}

	public void setUsuIcone(String usuIcone) {
		this.usuIcone = usuIcone;
	}
		

}
