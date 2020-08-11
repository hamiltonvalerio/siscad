package mb.amazul.siscad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mb.amazul.siscad.model.Empregado;
import mb.amazul.siscad.repository.EmpregadoRepository;

@Service("empregadoService")
public class EmpregadoServiceImpl implements EmpregadoService{
	
	@Autowired
	private EmpregadoRepository empregadoRepository;

	@Override
	public void save(Empregado empregado) {
		// TODO Auto-generated method stub
		empregadoRepository.save(empregado);
	}

	@Override
	public Empregado findByCpf(String cpf) {
		// TODO Auto-generated method stub
		return empregadoRepository.findByCpf(cpf);
	}

	@Override
	public List<Empregado> getEmpregados() {
		// TODO Auto-generated method stub
		return empregadoRepository.findByExcluido(false);
	}

	@Override
	public void updateExterno(Empregado empregado) {
		// TODO Auto-generated method stub
		//empregadoRepository.updateExterno(empregado);
	}

	@Override
	public Empregado findById(Long id) {
		// TODO Auto-generated method stub
		return empregadoRepository.findById(id).orElse(new Empregado());
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		empregadoRepository.deleteById(id);
	}

	@Override
	public void updatefinalizaexternofalse(Long id) {
		// TODO Auto-generated method stub
		empregadoRepository.updatefinalizaexterno(false, id);
	}
	
	@Override
	public void updateexcluido(Long id) {
		// TODO Auto-generated method stub
		empregadoRepository.updateexcluido(true, id);
	}
}
