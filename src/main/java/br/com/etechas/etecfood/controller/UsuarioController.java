package br.com.etechas.etecfood.controller;

import br.com.etechas.etecfood.entity.Usuario;
import br.com.etechas.etecfood.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
// Classe responsável por gerenciar as requisições relacionadas aos usuários.
public class UsuarioController {

    @Autowired
    // Repositório usado para operações de CRUD com a entidade   Usuario
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> listar(){
        return usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable Long id){
        var usuario = usuarioRepository.findById(id);
        if(usuario.isPresent())
            return usuario.get();
        return null;
    }

    @PostMapping
    public void cadastrar(@RequestBody Usuario usuario){
        UsuarioRepository.save(usuario);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        var usuario = UsuarioRepository.findById(id);
        if(usuario.isPresent())
            UsuarioRepository.delete(usuario.get());
    }
}
