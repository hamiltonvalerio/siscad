package mb.amazul.siscad.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mb.amazul.siscad.model.Perfil;
import mb.amazul.siscad.repository.PerfilRepository;

@Service("perfilService")
public class PerfilServiceImpl implements PerfilService{

	@Autowired
    private PerfilRepository perfilRepository;
	
	@Override
	public void save(Perfil perfil) {
		// TODO Auto-generated method stub
		perfil.setUsualt("Hamilton");
		perfil.setDatalt(new Date());
		perfilRepository.save(perfil);
	}

	@Override
	public List<Perfil> getPerfils() {
		// TODO Auto-generated method stub
		return perfilRepository.findAll();
	}

	@Override
	public Perfil findByNome(String perfil) {
		// TODO Auto-generated method stub
		return perfilRepository.findByNome(perfil);
	}

}
