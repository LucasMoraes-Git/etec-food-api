//Controller responsável pelos horários de funcionamento

package br.com.etechas.etecfood.controller;

import br.com.etechas.etecfood.entity.HorarioFuncionamento;
import br.com.etechas.etecfood.repository.HorarioFuncionamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class HorarioFuncionamentoController {
    @Autowired
    private HorarioFuncionamentoRepository horarioFuncionamentoRepository;

    @GetMapping
    public List<HorarioFuncionamento> listarTodos(){
        return horarioFuncionamentoRepository.findAll();
    }

    @GetMapping("/{id}")
    public HorarioFuncionamento buscarPorId(@PathVariable Long id){
        var horarioFuncionamento = horarioFuncionamentoRepository.findById(id);
        if(horarioFuncionamento.isPresent())
            return horarioFuncionamento.get();
        return null;
    }

    @PostMapping
    public void cadastrar(@RequestBody HorarioFuncionamento horarioFuncionamento){
        horarioFuncionamentoRepository.save(horarioFuncionamento);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id){
        var horarioFuncionamento = horarioFuncionamentoRepository.findById(id);
        if(horarioFuncionamento.isPresent())
            horarioFuncionamentoRepository.delete(horarioFuncionamento.get());
    }
}
