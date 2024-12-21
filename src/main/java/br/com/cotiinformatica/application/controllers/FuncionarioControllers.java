package br.com.cotiinformatica.application.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.domain.contracts.services.FuncionarioServices;
import br.com.cotiinformatica.domain.models.dtos.FuncionarioRequestDto;
import br.com.cotiinformatica.domain.models.dtos.FuncionarioResponseDto;

@RestController
@RequestMapping("api/funcionario")
public class FuncionarioControllers {
	@Autowired FuncionarioServices funcionarioServices;
	
	@PostMapping("/cadastrar")
	public FuncionarioResponseDto cadastrarFuncionario(FuncionarioRequestDto dto) {
		return funcionarioServices.cadastrarFuncionario(dto);
	}
	
	@GetMapping("/consultar")
	public List<FuncionarioResponseDto> consultarTodosFuncionarios() {
		return funcionarioServices.consultarTodosFuncionario();
	}
	
	@GetMapping("/consular/{id}")
	public FuncionarioResponseDto consultarFuncionarioPorId(UUID id) {
		return funcionarioServices.consultarPorId(id);
	}
	
}