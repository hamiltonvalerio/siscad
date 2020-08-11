package mb.amazul.siscad.service;

import java.util.List;

import mb.amazul.siscad.model.ArquivosEmp;
import mb.amazul.siscad.model.Empregado;

public interface ArquivosEmpService {

public void save(ArquivosEmp arquivosEmp);
	
	public List<ArquivosEmp> findByEmpregado(Empregado empregado);

	public void deleteById(String id);
	
	public ArquivosEmp findById(String id);

	ArquivosEmp findByEmpregadoAndDescricao(Empregado empregado, String descricao);
}
