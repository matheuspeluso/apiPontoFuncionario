package br.com.cotiinformatica.domain.contracts.services;

import br.com.cotiinformatica.domain.models.dtos.PontoRequestDto;
import br.com.cotiinformatica.domain.models.dtos.PontoResponseDto;

public interface PontoService {
	
	PontoResponseDto baterPontoEntrada(PontoRequestDto dto);
	
}
