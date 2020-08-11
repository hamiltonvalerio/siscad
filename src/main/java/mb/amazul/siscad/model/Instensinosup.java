package mb.amazul.siscad.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "instensinosup")
@Table(name = "instensinosup")
public class Instensinosup implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4308792429482372040L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name = "no_ies")
	private String no_ies;
	
	@Column(name = "sg_ies")
	private String sg_ies;

	@Column(name = "rede")
	private String rede;
	
	@Column(name = "datalt")
	private Date datalt;
	
	@Column(name = "usualt")
	private String usualt;

	public Instensinosup(Integer id, String no_ies, String sg_ies, String rede, Date datalt, String usualt) {
		super();
		this.id = id;
		this.no_ies = no_ies;
		this.sg_ies = sg_ies;
		this.rede = rede;
		this.datalt = datalt;
		this.usualt = usualt;
	}
	
	

	public Instensinosup() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNo_ies() {
		return no_ies;
	}

	public void setNo_ies(String no_ies) {
		this.no_ies = no_ies;
	}

	public String getSg_ies() {
		return sg_ies;
	}

	public void setSg_ies(String sg_ies) {
		this.sg_ies = sg_ies;
	}

	public String getRede() {
		return rede;
	}

	public void setRede(String rede) {
		this.rede = rede;
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

	
	
	
	
}
