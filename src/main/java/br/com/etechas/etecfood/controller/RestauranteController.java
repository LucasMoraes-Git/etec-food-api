package br.com.etechas.etecfood.controller;

import br.com.etechas.etecfood.entity.Restaurante;
import br.com.etechas.etecfood.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {
    @Autowired
    private RestauranteRepository restauranteRepository;

    @GetMapping
    public List<Restaurante> listar(){
        return restauranteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Restaurante buscarPorId(@PathVariable Long id){
        var restaurante = restauranteRepository.findById(id);
        if(restaurante.isPresent())
            return restaurante.get();
        return null;
    }

    @PostMapping
    public void cadastrar(@RequestBody Restaurante restaurante){
        restauranteRepository.save(restaurante);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id){
        var restaurante = restauranteRepository.findById(id);
        if(restaurante.isPresent())
            restauranteRepository.delete(restaurante.get());
    }
}
