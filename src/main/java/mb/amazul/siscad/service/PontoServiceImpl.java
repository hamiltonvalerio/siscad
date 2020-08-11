package mb.amazul.siscad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mb.amazul.siscad.model.Ponto;
import mb.amazul.siscad.model.Usuario;
import mb.amazul.siscad.repository.PontoRepository;

@Service("pontoService")
public class PontoServiceImpl implements PontoService{

	@Autowired
	private PontoRepository pontorepository;
	
	@Override
	public void save(Ponto ponto) {
		// TODO Auto-generated method stub
		pontorepository.save(ponto);
	}

	@Override
	public Ponto findByPonto(Ponto ponto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ponto> findAllByUsuario(Usuario usu) {
		// TODO Auto-generated method stub
		//return pontorepository.findTodoByUsuario(usu.getId());
		return pontorepository.findByUsuario(usu);
	}

}
