package emily.amorim.desafio_tecnico.repository;

import emily.amorim.desafio_tecnico.entity.Projeto;
import emily.amorim.desafio_tecnico.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

}
