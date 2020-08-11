package mb.amazul.siscad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mb.amazul.siscad.model.DependenteEmp;
import mb.amazul.siscad.model.Empregado;
import mb.amazul.siscad.repository.DependenteEmpRepository;

@Service("dependenteEmpServiceImpl")
public class DependenteEmpServiceImpl implements DependenteEmpService{

	@Autowired
	private DependenteEmpRepository dependenteEmpRepository;
	
	@Override
	public void save(DependenteEmp dependenteEmp) {
		// TODO Auto-generated method stub
		dependenteEmpRepository.save(dependenteEmp);
	}

	@Override
	public List<DependenteEmp> findByEmpregado(Empregado empregado) {
		// TODO Auto-generated method stub
		return dependenteEmpRepository.findByEmpregado(empregado);
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		dependenteEmpRepository.deleteById(Long.parseLong(id));
	}

}
