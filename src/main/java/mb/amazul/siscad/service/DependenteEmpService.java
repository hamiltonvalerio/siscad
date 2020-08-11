package mb.amazul.siscad.service;

import java.util.List;

import mb.amazul.siscad.model.DependenteEmp;
import mb.amazul.siscad.model.Empregado;

public interface DependenteEmpService {

	public void save(DependenteEmp dependenteEmp);
	
	public List<DependenteEmp> findByEmpregado(Empregado empregado);

	public void deleteById(String id);
	
}
