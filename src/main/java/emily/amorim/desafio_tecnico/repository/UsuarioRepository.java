package emily.amorim.desafio_tecnico.repository;

import emily.amorim.desafio_tecnico.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
