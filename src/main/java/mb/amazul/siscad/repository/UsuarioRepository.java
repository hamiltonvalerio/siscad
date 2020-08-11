package mb.amazul.siscad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import mb.amazul.siscad.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Usuario findByCpf(String cpf);

	List<Usuario> findAllByCpf(String cpf);

	@Transactional
	@Modifying
	@Query("UPDATE usuario u SET u.ativo = :valor	WHERE u.id = :id")
	void updateAtivo(@Param("id") Long id, @Param("valor") Integer valor);

	

	

	
}
