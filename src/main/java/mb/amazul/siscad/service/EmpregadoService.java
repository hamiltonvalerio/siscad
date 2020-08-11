package mb.amazul.siscad.service;

import java.util.List;

import mb.amazul.siscad.model.Empregado;


public interface EmpregadoService {
	
	public void save(Empregado empregado);
	
	public Empregado findByCpf(String cpf);
	
	public List<Empregado> getEmpregados();
	
	public void updateExterno(Empregado empregado);

	public Empregado findById(Long id);

	public void excluir(Long id);
	
	public void updatefinalizaexternofalse(Long id);

	void updateexcluido(Long id);	
}
