package br.com.etechas.etecfood.controller;

import br.com.etechas.etecfood.entity.Cardapio;
import br.com.etechas.etecfood.repository.CardapioRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

import static org.springframework.data.jpa.domain.JpaSort.path;

@RestController
@RequestMapping("/cardapio")
@Validated
public class CardapioController {
    private CardapioRepository cardapioRepository;

    @GetMapping
    public List<Cardapio> select(){
        return cardapioRepository.findAll();
    }

    @GetMapping("/(id)")
    public ResponseEntity<Cardapio> selectById(@PathVariable Long id)  {
        Cardapio obj = this.cardapioRepository.findById(id).get();
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public  ResponseEntity<Cardapio> criar(@RequestBody Cardapio obj){
        var novoCardapio = this.cardapioRepository.save(obj);
        return  ResponseEntity.status(HttpStatus.CREATED).body(novoCardapio);
    }

    @PutMapping("/(id)")
    public  ResponseEntity<Void> atualizar(@RequestBody Cardapio obj, @PathVariable long id) {

        this.cardapioRepository.save(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/(id)")
    public ResponseEntity<Void> deletar(@PathVariable long id)  {
        this.cardapioRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
