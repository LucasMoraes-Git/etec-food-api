package br.com.etechas.etecfood.repository;

import br.com.etechas.etecfood.entity.RestauranteFormaPagamento;
import br.com.etechas.etecfood.entity.RestauranteFormaPagamentoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestauranteFormaPagamentoRepository
        extends JpaRepository<RestauranteFormaPagamento, RestauranteFormaPagamentoId> {
}