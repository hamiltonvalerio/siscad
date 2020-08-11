package mb.amazul.siscad.utils;

import java.security.SecureRandom;
import java.util.Random;

public class GeradorSenha {
	
	private static final String CARACTERES_VALIDOS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+{}[]|:;<>?,./";
    private static final int TAMANHO_PADRAO = 6;
    private static final Random RANDOM = new SecureRandom();
    
    int tamanho;

	public GeradorSenha(int tamanho_livre) {
		super();
		if(tamanho_livre < 6) {
			this.tamanho = TAMANHO_PADRAO;
		}else {
			this.tamanho = tamanho_livre;
		}
	}
    
	
	public String geraSenha() {
		String pwd = "";
        for (int i=0; i<this.tamanho; i++) {
            int index = (int)(RANDOM.nextDouble()*CARACTERES_VALIDOS.length());
            pwd += CARACTERES_VALIDOS.substring(index, index+1);
        }
		return pwd;
	}
	
    
    
}
