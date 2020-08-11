package mb.amazul.siscad.utils;

public enum TiposSanguineos {
	
	A(1,"A"),
	B(2,"B"),
	O(3,"O"),
	AB(4,"AB");
	
	private final int codigotpsang;
	private final String nome;
	
	private TiposSanguineos(int codigotpsang, String nome) {
		this.codigotpsang = codigotpsang;
		this.nome = nome;
	}

	public String getCodigo() {
		return Integer.toString(codigotpsang);
	}
	
	public int getCodigotpsang() {
		return codigotpsang;
	}

	public String getNome() {
		return nome;
	}
	
	
}
