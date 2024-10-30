package br.com.fiap.sprint3.datasource;

import br.com.fiap.sprint3.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
