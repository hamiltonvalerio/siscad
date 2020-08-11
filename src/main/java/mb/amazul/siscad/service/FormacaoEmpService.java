package mb.amazul.siscad.service;

import java.util.List;

import mb.amazul.siscad.model.Empregado;
import mb.amazul.siscad.model.FormacaoEmp;

public interface FormacaoEmpService {
	
	public List<FormacaoEmp> findByEmpregado(Empregado empregado);

	public void save(FormacaoEmp form);

	public void deleteById(String id);
}
