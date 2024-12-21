package br.com.cotiinformatica.domain.models.dtos;

import java.util.Date;
import java.util.UUID;

import lombok.Data;

@Data
public class PontoResponseDto {
	
	 private UUID id;
	 private String nomePonto;
	 private Date dataHora;
	 private String mensagem;
}
