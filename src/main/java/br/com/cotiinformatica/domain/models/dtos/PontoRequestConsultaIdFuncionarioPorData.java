package br.com.cotiinformatica.domain.models.dtos;

import java.util.Date;
import java.util.UUID;

import lombok.Data;

@Data
public class PontoRequestConsultaIdFuncionarioPorData {
	private UUID idFuncionario;
	private Date dataIncio;
	private Date dataFim;

}
