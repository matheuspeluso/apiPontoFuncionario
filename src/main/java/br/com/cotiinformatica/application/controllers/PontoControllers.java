package br.com.cotiinformatica.application.controllers;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.domain.contracts.services.PontoService;
import br.com.cotiinformatica.domain.models.dtos.PontoRequestConsultaIdFuncionarioPorData;
import br.com.cotiinformatica.domain.models.dtos.PontoRequestDto;
import br.com.cotiinformatica.domain.models.dtos.PontoResponseDto;

@RestController
@RequestMapping("api/ponto")
public class PontoControllers {
	
	@Autowired PontoService pontoService;
	
	@PostMapping("/entrada")
	public PontoResponseDto RegistrarPontoEntrada(PontoRequestDto dto) {
		return pontoService.baterPontoEntradaTrabalho(dto);
	}
	
	@PostMapping("/entrada-almoco")
	public PontoResponseDto RegistrarInicioAlmoco(PontoRequestDto dto) {
		return pontoService.baterEntradaAlmoco(dto);
	}
	
	@PostMapping("/saida-almoco")
	public PontoResponseDto RegistrarSaidaAlmoco(PontoRequestDto dto) {
		return pontoService.baterSaidaAlmoco(dto);
	}
	
	@PostMapping("/saida-trabalho")
	public PontoResponseDto RegistrarSaidaTrabalho(PontoRequestDto dto) {
		return pontoService.baterPontoSaidaTrabalho(dto);
	}
	
	@GetMapping("/consultar/{idFuncionario}/{dataInicio}/{dataFim}")
	public List<PontoResponseDto> consultarPorIdEdata(
			@PathVariable UUID idFuncionario,
			@PathVariable String dataInicio,
			@PathVariable String dataFim
			) throws Exception{
		
		var dto = new PontoRequestConsultaIdFuncionarioPorData();
		dto.setIdFuncionario(idFuncionario);
		dto.setDataIncio(new SimpleDateFormat("yyyy-MM-dd").parse(dataInicio));
		dto.setDataFim(new SimpleDateFormat("yyyy-MM-dd").parse(dataFim));
		
		return pontoService.consultarPorId(dto);
	}


}
