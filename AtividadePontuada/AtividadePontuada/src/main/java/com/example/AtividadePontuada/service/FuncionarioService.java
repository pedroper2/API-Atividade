package com.example.AtividadePontuada.service;

import com.example.AtividadePontuada.model.Funcionario;
import com.example.AtividadePontuada.repository.FuncionarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class FuncionarioService {
    FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }
    public List <Funcionario> Listartodos(){
        return funcionarioRepository.findAll();
    }
    public Funcionario salvar (@Valid Funcionario funcionario){
        if(funcionarioRepository.findByEmail(funcionario.getEmail()).isPresent()){
            throw new IllegalArgumentException("Esse email ja foi cadastrado");
        }
        return funcionarioRepository.save(funcionario);
    }
    public Funcionario atualizar (@Valid Funcionario funcionario){
        Funcionario funcionarioatualizado = funcionarioRepository.findByEmail(funcionario.getEmail()).
                orElseThrow(()->new IllegalArgumentException("Usuario não encontrado"));
        funcionarioatualizado.setNome(funcionario.getNome());
        funcionarioatualizado.setCpf(funcionario.getCpf());
        funcionarioatualizado.setDataNascimento(funcionario.getDataNascimento());
        funcionarioatualizado.setSexo(funcionario.getSexo());
        funcionarioatualizado.setEstadoCivil(funcionario.getEstadoCivil());
        funcionarioatualizado.setSalario(funcionario.getSalario());
        funcionarioatualizado.setEmail(funcionario.getEmail());
        funcionarioatualizado.setEndereco(funcionario.getEndereco());
        return funcionarioRepository.save(funcionarioatualizado);
    }
    public void excluir (long id){
      Funcionario funcionarioexcluido  = funcionarioRepository.findById(id).
              orElseThrow(()->new IllegalArgumentException("Usuario não encontrado"));
      funcionarioRepository.delete(funcionarioexcluido);
    }
}
