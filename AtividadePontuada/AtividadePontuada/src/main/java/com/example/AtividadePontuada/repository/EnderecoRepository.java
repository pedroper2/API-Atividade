package com.example.AtividadePontuada.repository;

import com.example.AtividadePontuada.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository <Endereco, Long> {
}
