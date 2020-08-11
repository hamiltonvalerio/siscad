package mb.amazul.siscad.service;

import java.util.List;

import mb.amazul.siscad.model.Empregado;
import mb.amazul.siscad.model.Usuario;

public interface UsuarioService {
   
	public void save(Usuario usuario);
    
	public Usuario findByCpf(String cpf);
	
	public List<Usuario> findAllByCpf(String cpf);

	public List<Usuario> getUsuarios();

	public Usuario converteEmpregadoParaUsuario(Empregado empregado);
	
	public void updateAtivo(Long id, Integer valor);

	public Usuario findById(Long id);

	public Usuario getAuthenticatedUser();
}
