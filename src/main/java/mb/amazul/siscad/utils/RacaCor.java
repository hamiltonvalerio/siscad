package mb.amazul.siscad.utils;

public enum RacaCor {

	BRANCA(1,"Branca"),
	PRETA(2,"Preta"),
	AMARELA(3,"Amarela"),
	PARDA(4,"Parda"),
	INDIGENA(5,"Indígena");
	
	private final int codigoracacor;
	private final String nome;
	
	private RacaCor(int codigoracacor, String nome) {
		this.codigoracacor = codigoracacor;
		this.nome = nome;
	}

	public String getCodigo() {
		return Integer.toString(codigoracacor);
	}
	
	public int getCodigoracacor() {
		return codigoracacor;
	}

	public String getNome() {
		return nome;
	}

}
