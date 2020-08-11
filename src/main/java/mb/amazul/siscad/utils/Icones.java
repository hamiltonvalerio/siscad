package mb.amazul.siscad.utils;

public enum Icones {

	USERINATIVO("user_inativo"),
	USEREMADMISSAO("user_em_admissao"),
	USERFINALIZADO("user_finalizado");
	
	private String imagem;

	public String getImagem() {
		return imagem;
	}

	private Icones(String imagem) {
		this.imagem = imagem;
	}
	
	
}
