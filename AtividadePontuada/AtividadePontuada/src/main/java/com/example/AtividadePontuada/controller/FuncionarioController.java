package com.example.AtividadePontuada.controller;

import com.example.AtividadePontuada.model.Funcionario;
import com.example.AtividadePontuada.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping ("/funcionario")
public class FuncionarioController {
    FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }


    @GetMapping
    public List <Funcionario> Listartodos (){
        return funcionarioService.Listartodos();
    }

    @PostMapping
    public ResponseEntity <Map<String, Object>> salvar (@Valid @RequestBody Funcionario funcionario){
        funcionarioService.salvar(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("Mensagem", "Funcionario salvo com sucesso"));
    }

    @PutMapping
    public  ResponseEntity <Map <String, Object>> atualizar (@Valid @RequestBody Funcionario funcionario){
        funcionarioService.atualizar(funcionario);
        return ResponseEntity.ok().body(Map.of("Mensagem", "Usuario atualizado com sucesso"));
    }
    @DeleteMapping ("/{id}")
    public  ResponseEntity <Map<String, Object>>delete (@PathVariable long id){
        funcionarioService.excluir(id);
        return ResponseEntity.ok().body(Map.of("Mensagem","UsuariO excluido com sucesso"));
    }
}
