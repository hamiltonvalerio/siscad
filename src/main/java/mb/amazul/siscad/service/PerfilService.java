package mb.amazul.siscad.service;

import java.util.List;

import mb.amazul.siscad.model.Perfil;

public interface PerfilService {
	
	public void save(Perfil perfil);

	public Perfil findByNome(String perfil);
	
	public List<Perfil> getPerfils();
}
