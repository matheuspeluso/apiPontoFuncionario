package br.com.cotiinformatica.domain.models.dtos;

import java.util.UUID;

import lombok.Data;

@Data
public class FuncionarioResponseDto {
	private UUID id;
	private String nome;
	private String cargo;
	//private List<Ponto> pontos;
}
