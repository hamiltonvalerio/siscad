package mb.amazul.siscad.utils;

public enum EntradaSaida {
	
	ENTRADA(1,"Entrada"),
	SAIDA(2,"Saída");
	
	private final int codigoentsai;
	private final String nome;
	
	private EntradaSaida(int codigoentsai, String nome) {
		this.codigoentsai = codigoentsai;
		this.nome = nome;
	}

	public String getCodigo() {
		return Integer.toString(codigoentsai);
	}
	
	public int getCodigoentsai() {
		return codigoentsai;
	}

	public String getNome() {
		return nome;
	}
	
	
}
