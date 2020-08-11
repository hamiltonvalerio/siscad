package mb.amazul.siscad.service;

import java.util.List;

import mb.amazul.siscad.model.Ponto;
import mb.amazul.siscad.model.Usuario;

public interface PontoService {
	
	public void save(Ponto ponto);
	
	public Ponto findByPonto(Ponto ponto);

	public List<Ponto> findAllByUsuario(Usuario usu);
	
	
}
