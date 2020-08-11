package mb.amazul.siscad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mb.amazul.siscad.model.ArquivosEmp;
import mb.amazul.siscad.model.Empregado;
import mb.amazul.siscad.repository.ArquivosEmpRepository;

@Service("arquivosEmpServiceImpl")
public class ArquivosEmpServiceImpl implements ArquivosEmpService{

	@Autowired
	private ArquivosEmpRepository arquivosEmpRepository;
	
	
	@Override
	public void save(ArquivosEmp arquivosEmp) {
		// TODO Auto-generated method stub
		arquivosEmpRepository.save(arquivosEmp);
	}

	@Override
	public List<ArquivosEmp> findByEmpregado(Empregado empregado) {
		// TODO Auto-generated method stub
		return arquivosEmpRepository.findByEmpregado(empregado);
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		arquivosEmpRepository.deleteById(Long.parseLong(id));
	}

	@Override
	public ArquivosEmp findById(String id) {
		// TODO Auto-generated method stub
		return arquivosEmpRepository.findById(Long.parseLong(id)).orElse(new ArquivosEmp());
	}
	
	@Override
	public ArquivosEmp findByEmpregadoAndDescricao(Empregado empregado, String descricao) {
		
		return arquivosEmpRepository.findByEmpregadoAndDescricao(empregado,descricao);
	}

}
