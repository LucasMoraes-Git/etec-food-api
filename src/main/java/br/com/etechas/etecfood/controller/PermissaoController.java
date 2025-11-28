package br.com.etechas.etecfood.controller;

import br.com.etechas.etecfood.entity.Permissao;
import br.com.etechas.etecfood.entity.Usuario;
import br.com.etechas.etecfood.repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.etechas.etecfood.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/permissao")
// Classe responsável por gerenciar as requisições relacionadas aos usuários.
public class PermissaoController {

    @Autowired
    // Repositório usado para operações de CRUD com a entidade Usuario
    private PermissaoRepository permissaoRepository;

    @GetMapping
    public List<Permissao> listar(){
            return permissaoRepository.findAll();
        }

    @GetMapping("/{id}")
    public Permissao buscarPorId(@PathVariable Long id){
        var permissao = permissaoRepository.findById(id);
        if(permissao.isPresent())
            return permissao.get();
        return null;
    }

    @PostMapping
    public void cadastrar(@RequestBody Permissao permissao){
        permissaoRepository.save(permissao);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        var permissao = permissaoRepository.findById(id);
        if(permissao.isPresent())
            permissaoRepository.delete(permissao.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Permissao> atualizar(@PathVariable Long id){
        var permissao = permissaoRepository.findById(id);
        if(permissao.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(permissao.get());
        }
        return ResponseEntity.notFound().build();
    }
}

