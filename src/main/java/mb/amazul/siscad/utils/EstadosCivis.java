package mb.amazul.siscad.utils;

public enum EstadosCivis {
	
	SOLTEIRO(1,"Solteiro"),
	CASADO(2,"Casado"),
	SEPARADO(3,"Separado"),
	DIVORCIADO(4,"Divorciado"),
	VIUVO(5,"Viúvo");
	
	private final int codigoec;
	private final String nome;
	
	private EstadosCivis(int codigoec, String nome) {
		this.codigoec = codigoec;
		this.nome = nome;
	}
	
	public String getCodigo() {
		return Integer.toString(codigoec);
	}

	public int getCodigoec() {
		return codigoec;
	}

	public String getNome() {
		return nome;
	}
	
	
}
