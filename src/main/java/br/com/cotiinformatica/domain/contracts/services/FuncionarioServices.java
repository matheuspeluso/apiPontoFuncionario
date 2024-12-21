package br.com.cotiinformatica.domain.contracts.services;

import java.util.List;
import java.util.UUID;

import br.com.cotiinformatica.domain.models.dtos.FuncionarioRequestDto;
import br.com.cotiinformatica.domain.models.dtos.FuncionarioResponseDto;

public interface FuncionarioServices {
	
	FuncionarioResponseDto cadastrarFuncionario(FuncionarioRequestDto dto);
	
	public List<FuncionarioResponseDto> consultarTodosFuncionario();
	
	public FuncionarioResponseDto consultarPorId(UUID id);
}
