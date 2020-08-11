package mb.amazul.siscad.model;

import java.io.Serializable;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import mb.amazul.siscad.utils.EntradaSaida;

@Entity(name = "batida")
@Table(name = "batida")
public class Batida implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8085612430746751386L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private EntradaSaida entradaSaida;
	
	@Column(name = "localTime")
	@DateTimeFormat(iso = ISO.TIME)
    private LocalTime localTime;
	
	

	public Batida(Long id, EntradaSaida entradaSaida, LocalTime localTime) {
		super();
		this.id = id;
		this.entradaSaida = entradaSaida;
		this.localTime = localTime;
	}

	public Batida() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EntradaSaida getEntradaSaida() {
		return entradaSaida;
	}

	public void setEntradaSaida(EntradaSaida entradaSaida) {
		this.entradaSaida = entradaSaida;
	}

	public LocalTime getLocalTime() {
		return localTime;
	}

	public void setLocalTime(LocalTime localTime) {
		this.localTime = localTime;
	}
	
	
}
