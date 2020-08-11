package mb.amazul.siscad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mb.amazul.siscad.model.Empregado;
import mb.amazul.siscad.model.FormacaoEmp;
import mb.amazul.siscad.repository.FormacaoEmpRepository;

@Service("formacaoEmpService")
public class FormacaoEmpServiceImpl implements FormacaoEmpService{

	@Autowired
	private FormacaoEmpRepository formacaoEmpRepository;
	
	
	@Override
	public List<FormacaoEmp> findByEmpregado(Empregado empregado) {
		// TODO Auto-generated method stub
		return formacaoEmpRepository.findByEmpregado(empregado);
	}


	@Override
	public void save(FormacaoEmp form) {
		// TODO Auto-generated method stub
		formacaoEmpRepository.save(form);
	}


	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		formacaoEmpRepository.deleteById(Long.parseLong(id));
	}

}
