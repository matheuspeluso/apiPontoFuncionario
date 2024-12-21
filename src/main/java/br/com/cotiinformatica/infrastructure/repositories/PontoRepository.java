package br.com.cotiinformatica.infrastructure.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cotiinformatica.domain.models.entities.Ponto;

public interface PontoRepository extends JpaRepository<Ponto, UUID> {
   
}
	