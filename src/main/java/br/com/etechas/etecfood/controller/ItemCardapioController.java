package br.com.etechas.etecfood.controller;


import br.com.etechas.etecfood.entity.Cardapio;
import br.com.etechas.etecfood.entity.ItemCardapio;
import br.com.etechas.etecfood.repository.CardapioRepository;
import br.com.etechas.etecfood.repository.ItemCardapioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

import static org.springframework.web.servlet.function.RequestPredicates.path;

@RestController
@RequestMapping("/itemCardapio")
@Validated
public class ItemCardapioController {
    private ItemCardapioRepository itemCardapioRepository;

    @GetMapping
    public List<ItemCardapio> select(){
        return itemCardapioRepository.findAll();
    }

    @GetMapping("/(id)")
    public ResponseEntity<Cardapio> selectById(@PathVariable long id)  {
        Cardapio obj = this.itemCardapioRepository.findById(id).get().getCardapio();
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public  ResponseEntity<ItemCardapio> criar(@RequestBody ItemCardapio obj){
        this.itemCardapioRepository.save(obj);
        return  ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

    @PutMapping("/(id)")
    public  ResponseEntity<Void> atualizar(@RequestBody ItemCardapio obj, @PathVariable long id) {

        this.itemCardapioRepository.save(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/(id)")
    public ResponseEntity<Void> deletar(@PathVariable long id)  {
        this.itemCardapioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
