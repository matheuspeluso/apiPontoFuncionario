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

    @Column(name = "inicio_servico", nullable = true)
    private Date inicioServico;

    @Column(name = "inicio_almoco", nullable = true)
    private Date inicioAlmoco;

    @Column(name = "fim_almoco", nullable = true)
    private Date fimAlmoco;

    @Column(name = "fim_servico", nullable = true)
    private Date fimServico;

    @ManyToOne
    @JoinColumn(name = "funcionario_id", nullable = false)
    private Funcionario funcionario;
}
