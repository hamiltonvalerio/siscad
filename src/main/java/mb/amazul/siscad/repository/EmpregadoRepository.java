package mb.amazul.siscad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import mb.amazul.siscad.model.Empregado;

public interface EmpregadoRepository extends JpaRepository<Empregado, Long>{
	
	Empregado findByCpf(String cpf);

	//void updateExterno(Empregado empregado);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE empregado SET finalizadoexterno = ? WHERE id = ?", 
			  nativeQuery = true)
	void updatefinalizaexterno(Boolean bol, Long id);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE empregado SET excluido = ? WHERE id = ?", 
			  nativeQuery = true)
	void updateexcluido(Boolean bol, Long id);

	List<Empregado> findByExcluido(boolean b);
}
