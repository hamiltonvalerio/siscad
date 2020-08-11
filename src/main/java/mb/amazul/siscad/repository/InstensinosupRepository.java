package mb.amazul.siscad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mb.amazul.siscad.model.Instensinosup;

public interface InstensinosupRepository extends JpaRepository<Instensinosup, Integer>{

	@Query("SELECT no_ies from instensinosup WHERE no_is LIKE CONCAT('%',:no_ies,'%')")
	List<Instensinosup> findByNo_ies(@Param("no_ies") String no_ies);
	
}
