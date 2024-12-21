package br.com.cotiinformatica.domain.models.dtos;

import java.util.UUID;

import lombok.Data;

@Data
public class PontoRequestDto {
	private UUID idFuncionario;
	private String nomeFuncionario;

}
