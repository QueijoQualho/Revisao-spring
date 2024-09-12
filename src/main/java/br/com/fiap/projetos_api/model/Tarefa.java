package br.com.fiap.projetos_api.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.UUID;

@Data
@ToString
@Entity
@Table(name = "tb_tarefa")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column(name = "descricao", length = 100, nullable = false)
    private String descricao;

    @Column(name = "duracao", nullable = false)
    private int esforcoEstimado;

    // @ManyToMany
    // @JoinTable(
    //         name = "tarefa_recurso",
    //         joinColumns = @JoinColumn(name = "tarefa_id"),
    //         inverseJoinColumns = @JoinColumn(name = "recurso_id")
    // )
    // private List<Recurso> recursos;

}
