package br.com.etechas.etecfood.repository;

import br.com.etechas.etecfood.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
