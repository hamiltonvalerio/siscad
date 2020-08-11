package mb.amazul.siscad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mb.amazul.siscad.model.DependenteEmp;
import mb.amazul.siscad.model.Empregado;

public interface DependenteEmpRepository extends JpaRepository<DependenteEmp, Long>{

	List<DependenteEmp> findByEmpregado(Empregado empregado);

	
	
}
