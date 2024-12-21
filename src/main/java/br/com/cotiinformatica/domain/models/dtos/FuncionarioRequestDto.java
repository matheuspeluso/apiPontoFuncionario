package br.com.cotiinformatica.domain.models.dtos;

import lombok.Data;

@Data
public class FuncionarioRequestDto {
    //private UUID funcionarioId;
    private String nome;
    private String cargo;
}
