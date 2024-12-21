package br.com.cotiinformatica.domain.models.entities;

import java.util.List;
import java.util.UUID;

import br.com.cotiinformatica.domain.models.Cargo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_funcionario")
public class Funcionario {
	@Id
	@Column(name = "id")
	private UUID id;
	
	@Column(name = "nome" , length = 50, nullable = false)
	private String nome;
	
	@Column(name = "cargo", nullable = false)
	Cargo cargo;
	
	@Column(name = "coordenada", nullable = false)
	private String coordenada;
	
	@OneToMany(mappedBy = "funcionario") 
    private List<Ponto> pontos;
}
