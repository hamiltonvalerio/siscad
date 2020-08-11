package mb.amazul.siscad.service;

import java.util.List;

import mb.amazul.siscad.model.Sistema;

public interface SistemaService {
	
	public void save(Sistema sistema);
	
	public Sistema findByNome(String nome);
	
	public List<Sistema> listaTodosSistemas();
	
	public List<Sistema> findByParcialNome(String nome);

}
