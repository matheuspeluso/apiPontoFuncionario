package br.com.cotiinformatica.domain.services;

import br.com.cotiinformatica.domain.models.dtos.FuncionarioRequestDto;
import br.com.cotiinformatica.domain.models.dtos.FuncionarioResponseDto;

public interface PontoService {
	
	FuncionarioResponseDto baterPontoInicioAlmoco(FuncionarioRequestDto dto);
	
	FuncionarioResponseDto baterPontoFinalAlmoco(FuncionarioRequestDto dto);
	
	FuncionarioResponseDto baterPontoSaida(FuncionarioRequestDto dto);
}
