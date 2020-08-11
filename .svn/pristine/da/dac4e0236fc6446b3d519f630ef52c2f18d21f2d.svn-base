package mb.amazul.siscad.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mb.amazul.siscad.model.Sistema;
import mb.amazul.siscad.repository.SistemaRepository;

@Service("sistemaService")
public class SistemaServiceImpl implements SistemaService{

	@Autowired
	private SistemaRepository sistemaRepository;
	
	@Override
	public void save(Sistema sistema) {
		// TODO Auto-generated method stub
		sistema.setUsualt("Hamilton");
		sistema.setDatalt(new Date());
		sistemaRepository.save(sistema);
	}

	@Override
	public Sistema findByNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sistema> listaTodosSistemas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sistema> findByParcialNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}
