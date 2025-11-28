package br.com.etechas.etecfood.controller;

import br.com.etechas.etecfood.entity.RestauranteFormaPagamento;
import br.com.etechas.etecfood.entity.RestauranteFormaPagamentoId;
import br.com.etechas.etecfood.repository.RestauranteFormaPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurante-forma-pagamento")
public class RestauranteFormaPagamentoController {

    @Autowired
    private RestauranteFormaPagamentoRepository repository;

    @GetMapping
    public List<RestauranteFormaPagamento> listar() {
        return repository.findAll();
    }

    @GetMapping("/{restauranteId}/{formaPagamentoId}")
    public ResponseEntity<RestauranteFormaPagamento> buscarPorId(
            @PathVariable Long restauranteId,
            @PathVariable Long formaPagamentoId) {

        RestauranteFormaPagamentoId id = new RestauranteFormaPagamentoId();
        id.setRestauranteId(restauranteId);
        id.setFormaPagamentoId(formaPagamentoId);

        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RestauranteFormaPagamento> cadastrar(
            @RequestBody RestauranteFormaPagamento associa) {

        RestauranteFormaPagamento salvo = repository.save(associa);
        return ResponseEntity.ok(salvo);
    }

    @DeleteMapping("/{restauranteId}/{formaPagamentoId}")
    public ResponseEntity<Object> excluir(
            @PathVariable Long restauranteId,
            @PathVariable Long formaPagamentoId) {

        RestauranteFormaPagamentoId id = new RestauranteFormaPagamentoId();
        id.setRestauranteId(restauranteId);
        id.setFormaPagamentoId(formaPagamentoId);

        return repository.findById(id)
                .map(registro -> {
                    repository.delete(registro);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}