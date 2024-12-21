package br.com.cotiinformatica.infrastructure.repositories;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.cotiinformatica.domain.models.entities.Ponto;

public interface PontoRepository extends JpaRepository<Ponto, UUID> {
	
	@Query("SELECT p FROM Ponto p WHERE p.funcionario.id = :idFuncionario AND p.dataHora >= :dataInicio AND p.dataHora < :dataFim")
	List<Ponto> findPontosByFuncionarioIdAndData(
	    @Param("idFuncionario") UUID idFuncionario,
	    @Param("dataInicio") Date dataInicio,
	    @Param("dataFim") Date dataFim
	);


}
	