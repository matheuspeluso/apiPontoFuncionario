package br.com.cotiinformatica.infrastructure.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cotiinformatica.domain.models.entities.Funcionario;
import br.com.cotiinformatica.domain.models.entities.Ponto;

public interface FuncionarioRepository extends JpaRepository<Funcionario, UUID> {
    Optional<Ponto> findFirstByFuncionarioIdOrderByInicioServicoDesc(UUID funcionarioId);
}