package br.com.cotiinformatica.domain.contracts.services;

import br.com.cotiinformatica.domain.models.dtos.FuncionarioRequestDto;
import br.com.cotiinformatica.domain.models.dtos.FuncionarioResponseDto;

public interface FuncionarioServices {
	
	FuncionarioResponseDto cadastrarFuncionario(FuncionarioRequestDto dto);
	
}
