package br.com.cotiinformatica.domain.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.domain.contracts.services.PontoService;
import br.com.cotiinformatica.domain.models.dtos.PontoRequestConsultaIdFuncionarioPorData;
import br.com.cotiinformatica.domain.models.dtos.PontoRequestDto;
import br.com.cotiinformatica.domain.models.dtos.PontoResponseDto;
import br.com.cotiinformatica.domain.models.entities.Ponto;
import br.com.cotiinformatica.infrastructure.repositories.FuncionarioRepository;
import br.com.cotiinformatica.infrastructure.repositories.PontoRepository;

@Service
public class PontoServiceImpl implements PontoService {

	@Autowired FuncionarioRepository funcionarioRepository;
	@Autowired PontoRepository pontoRepository;
	
	@Override
	public PontoResponseDto baterPontoEntradaTrabalho(PontoRequestDto dto) {
		
		var funcionario = funcionarioRepository.findById(dto.getIdFuncionario())
				.orElseThrow(() -> new IllegalArgumentException("Funcionario não encontrado. Verifique o ID informado."));
		
		var ponto = new Ponto();
		ponto.setId(UUID.randomUUID());
		ponto.setFuncionario(funcionario);
		ponto.setNomePonto("Entrada");
		ponto.setDataHora(new Date());
		
		pontoRepository.save(ponto);
		
		var response = new PontoResponseDto();
		response.setId(ponto.getId());
		response.setDataHora(ponto.getDataHora());
		response.setNomePonto(ponto.getNomePonto());
		response.setMensagem("Ponto registrado com sucesso!");
		
		return response;
	}

	@Override
	public PontoResponseDto baterEntradaAlmoco(PontoRequestDto dto) {
		var funcionario = funcionarioRepository.findById(dto.getIdFuncionario())
				.orElseThrow(() -> new IllegalArgumentException("Funcionario não encontrado. Verifique o ID informado."));
		
		var ponto = new Ponto();
		ponto.setId(UUID.randomUUID());
		ponto.setFuncionario(funcionario);
		ponto.setNomePonto("EntradaAlmoço");
		ponto.setDataHora(new Date());
		
		pontoRepository.save(ponto);
		
		var response = new PontoResponseDto();
		response.setId(ponto.getId());
		response.setDataHora(ponto.getDataHora());
		response.setNomePonto(ponto.getNomePonto());
		response.setMensagem("Inicio de almoço iniciado com sucesso!");
		
		return response;
	}

	@Override
	public PontoResponseDto baterSaidaAlmoco(PontoRequestDto dto) {
		var funcionario = funcionarioRepository.findById(dto.getIdFuncionario())
				.orElseThrow(() -> new IllegalArgumentException("Funcionario não encontrado. Verifique o ID informado."));
		
		var ponto = new Ponto();
		ponto.setId(UUID.randomUUID());
		ponto.setFuncionario(funcionario);
		ponto.setNomePonto("SaidaAlmoço");
		ponto.setDataHora(new Date());
		
		pontoRepository.save(ponto);
		
		var response = new PontoResponseDto();
		response.setId(ponto.getId());
		response.setDataHora(ponto.getDataHora());
		response.setNomePonto(ponto.getNomePonto());
		response.setMensagem("Ponto de Saida de almoço batido com sucesso!");
		
		return response;
	}

	@Override
	public PontoResponseDto baterPontoSaidaTrabalho(PontoRequestDto dto) {
		var funcionario = funcionarioRepository.findById(dto.getIdFuncionario())
				.orElseThrow(() -> new IllegalArgumentException("Funcionario não encontrado. Verifique o ID informado."));
		
		var ponto = new Ponto();
		ponto.setId(UUID.randomUUID());
		ponto.setFuncionario(funcionario);
		ponto.setNomePonto("SaidaTrabalho");
		ponto.setDataHora(new Date());
		
		pontoRepository.save(ponto);
		
		var response = new PontoResponseDto();
		response.setId(ponto.getId());
		response.setDataHora(ponto.getDataHora());
		response.setNomePonto(ponto.getNomePonto());
		response.setMensagem("Ponto de saida Batido com sucesso!");
		
		return response;
	}

	@Override
	public List<PontoResponseDto> consultarPorId(PontoRequestConsultaIdFuncionarioPorData dto) {
	    // Verifica se o funcionário existe
	    var funcionario = funcionarioRepository.findById(dto.getIdFuncionario())
	            .orElseThrow(() -> new IllegalArgumentException("Funcionário não encontrado. Verifique o ID informado."));

	    // Consulta os pontos do funcionário no intervalo de data especificado
	    var pontos = pontoRepository.findPontosByFuncionarioIdAndData(
	            funcionario.getId(), dto.getDataIncio(), dto.getDataFim());

	    // Lista para armazenar as respostas
	    List<PontoResponseDto> responseList = new ArrayList<>();

	    // Mapeia os pontos encontrados para a resposta usando for
	    for (Ponto ponto : pontos) {
	        var response = new PontoResponseDto();
	        response.setId(ponto.getId());
	        response.setDataHora(ponto.getDataHora());
	        response.setNomePonto(ponto.getNomePonto());
	        response.setMensagem("Consulta realizada com sucesso para o ponto: " + ponto.getNomePonto());
	        responseList.add(response);
	    }

	    return responseList;
	}


	

}
