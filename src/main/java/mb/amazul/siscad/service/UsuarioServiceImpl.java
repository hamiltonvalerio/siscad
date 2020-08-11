package mb.amazul.siscad.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import mb.amazul.siscad.model.Empregado;
import mb.amazul.siscad.model.Usuario;
import mb.amazul.siscad.repository.PerfilRepository;
import mb.amazul.siscad.repository.UsuarioRepository;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private PerfilRepository perfilRepository;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
	private UsuarioSession usuarioSession;

    @Override
    public Usuario findByCpf(String cpf) {
    	return usuarioRepository.findByCpf(cpf);
    }
    
    @Override
    public void save(Usuario usuario) {
    	usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
    	usuario.setAtivo(0);
    	//Perfil perfil = perfilRepository.find("ADMIN");
    	//usuario.setPerfis(new HashSet<Perfil>(Arrays.asList(perfil)));
    	usuarioRepository.save(usuario);
    }

	@Override
	public List<Usuario> getUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario converteEmpregadoParaUsuario(Empregado empregado) {
		Usuario usu = new Usuario();
		usu.setCpf(empregado.getCpf().replaceAll("[^0-9]", ""));
		usu.setNome(empregado.getNome());
		return usu;
	}

	@Override
	public List<Usuario> findAllByCpf(String cpf) {
		// TODO Auto-generated method stub
		return usuarioRepository.findAllByCpf(cpf);
	}

	@Override
	public void updateAtivo(Long id, Integer valor) {
		// TODO Auto-generated method stub
		usuarioRepository.updateAtivo(id,valor);
	}

	@Override
	public Usuario findById(Long id) {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(id).orElse(new Usuario());
	}

	@Override
	public Usuario getAuthenticatedUser() {
		// TODO Auto-generated method stub
		Object usuarioLogado = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if (usuarioLogado instanceof UserDetails) {
			username = ((UserDetails) usuarioLogado).getUsername();
		} else {
			username = usuarioLogado.toString();
		}
		
		Usuario u = findByCpf(username); 
		
		usuarioSession.setUsuario(u);

		return u;
	}


	

}
