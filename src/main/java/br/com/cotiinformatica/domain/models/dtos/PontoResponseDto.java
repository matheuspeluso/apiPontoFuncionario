package br.com.cotiinformatica.domain.models.dtos;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import br.com.cotiinformatica.domain.models.entities.Funcionario;
import lombok.Data;

@Data
public class PontoResponseDto {
	
	 private UUID id;
	 private Date inicioServico;
	 private Date inicioAlmoco;
	 private Date fimAlmoco;
	 private Date fimServico;
}
