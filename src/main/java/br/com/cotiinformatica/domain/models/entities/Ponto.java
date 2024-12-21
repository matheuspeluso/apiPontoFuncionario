package br.com.cotiinformatica.domain.models.entities;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_ponto")
public class Ponto {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "data_hora", nullable = true)
    private Date dataHora;

    @Column(name = "nome_ponto", nullable = true)
    private String nomePonto;

    @ManyToOne
    @JoinColumn(name = "funcionario_id", nullable = false)
    private Funcionario funcionario;
}
