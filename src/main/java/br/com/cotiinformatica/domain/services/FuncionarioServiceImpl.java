package br.com.cotiinformatica.domain.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.domain.contracts.services.FuncionarioServices;
import br.com.cotiinformatica.domain.models.Cargo;
import br.com.cotiinformatica.domain.models.dtos.FuncionarioRequestDto;
import br.com.cotiinformatica.domain.models.dtos.FuncionarioResponseDto;
import br.com.cotiinformatica.domain.models.entities.Funcionario;
import br.com.cotiinformatica.infrastructure.componnets.GeradorDeCoordenadas;
import br.com.cotiinformatica.infrastructure.repositories.FuncionarioRepository;
import br.com.cotiinformatica.infrastructure.repositories.PontoRepository;

@Service
public class FuncionarioServiceImpl implements FuncionarioServices{
	@Autowired FuncionarioRepository funcionarioRepository;
	@Autowired PontoRepository pontoRepository;
	
	@Autowired GeradorDeCoordenadas geradorDeCoordenadas;

	@Override
	public FuncionarioResponseDto cadastrarFuncionario(FuncionarioRequestDto dto) {
		var funcionario = new Funcionario();
		
		funcionario.setId(UUID.randomUUID());
		funcionario.setNome(dto.getNome());
		funcionario.setCargo(Cargo.valueOf(dto.getCargo()));
		funcionario.setCoordenada(geradorDeCoordenadas.gerarCoordenada());
		
		var response = new FuncionarioResponseDto();
		response.setId(funcionario.getId());
		response.setNome(funcionario.getNome());
		response.setCargo(funcionario.getCargo().toString());
		response.setCoordenada(funcionario.getCoordenada());
		
		funcionarioRepository.save(funcionario);
			
		return response;
	}
	

}
