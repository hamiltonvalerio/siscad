package mb.amazul.siscad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mb.amazul.siscad.model.Empregado;
import mb.amazul.siscad.model.FormacaoEmp;

public interface FormacaoEmpRepository extends JpaRepository<FormacaoEmp, Long>{
	
	List<FormacaoEmp> findByEmpregado(Empregado empregado);
}
