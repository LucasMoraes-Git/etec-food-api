package br.com.etechas.etecfood.controllers;

import br.com.etechas.etecfood.entitys.Entregador;
import br.com.etechas.etecfood.repository.EntregadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entregador")

public class EntregadorController {

    @Autowired
    private EntregadorRepository entregadorRepository;

    @GetMapping
    public List<Entregador> listar () {
        return entregadorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Entregador buscarId (@PathVariable Long id) {
        var entregadorId = entregadorRepository.findById(id);

        if(entregadorId.isPresent())
            return entregadorId.get();
        return null;
    }

    @PostMapping
    public void cadastrar(@RequestBody Entregador entregador) {
        entregadorRepository.save(entregador);
    }

    @PutMapping("/{id}")
    public void atualizarPorId (@RequestBody Entregador entregador, @PathVariable Long id) {
        var entreadorId = entregadorRepository.findById(id);
        if(entreadorId.isPresent())
            entregadorRepository.save(entregador);
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable Long id) {
        var entregadorId = entregadorRepository.findById(id);

        if (entregadorId.isPresent())
            entregadorRepository.deleteById(id);
    }
}
