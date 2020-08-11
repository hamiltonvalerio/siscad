package mb.amazul.siscad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mb.amazul.siscad.model.ArquivosEmp;
import mb.amazul.siscad.model.Empregado;

public interface ArquivosEmpRepository extends JpaRepository<ArquivosEmp, Long>{

	List<ArquivosEmp> findByEmpregado(Empregado empregado);
	
	void deleteById(Long id);

	ArquivosEmp findByEmpregadoAndDescricao(Empregado empregado, String descricao);
	
	
}
