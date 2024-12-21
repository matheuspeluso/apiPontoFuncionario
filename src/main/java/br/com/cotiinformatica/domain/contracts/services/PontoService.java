package br.com.cotiinformatica.domain.contracts.services;

import br.com.cotiinformatica.domain.models.dtos.PontoRequestDto;
import br.com.cotiinformatica.domain.models.dtos.PontoResponseDto;

public interface PontoService {
	
	PontoResponseDto baterPontoEntradaTrabalho(PontoRequestDto dto);
	
	PontoResponseDto baterEntradaAlmoco(PontoRequestDto dto);
	
	PontoResponseDto baterSaidaAlmoco(PontoRequestDto dto);
	
	PontoResponseDto baterPontoSaidaTrabalho(PontoRequestDto dto);
	
}
