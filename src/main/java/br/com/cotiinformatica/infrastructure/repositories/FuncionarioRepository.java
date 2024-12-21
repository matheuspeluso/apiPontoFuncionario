package br.com.cotiinformatica.infrastructure.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cotiinformatica.domain.models.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, UUID> {
  
}