package mb.amazul.siscad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mb.amazul.siscad.model.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Long>{

	Perfil findByNome(String perfil);

}
