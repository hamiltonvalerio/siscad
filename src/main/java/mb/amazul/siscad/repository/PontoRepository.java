package mb.amazul.siscad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mb.amazul.siscad.model.Ponto;
import mb.amazul.siscad.model.Usuario;

public interface PontoRepository extends JpaRepository<Ponto, Long>{

	@Query("SELECT data,  hora, tipo, foto\r\n" + 
			"	FROM ponto WHERE usuario_id = :id ORDER BY id desc")
	List<Ponto> findTodoByUsuario(@Param("id") Long id);
	

	List<Ponto> findByUsuario(Usuario usu);


}
