package br.com.etechas.etecfood.repository;

import br.com.etechas.etecfood.entity.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
}
