package br.com.fiap.projetos_api.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@ToString
@Entity
@Table(name = "tb_recurso")
public class Recurso {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column(name = "nome_recurso", length = 100, nullable = false)
    private String nome;

    @Column(name = "valor_hora", precision = 10, scale = 2)
    private BigDecimal valorHora;

    //@ManyToMany(mappedBy = "recursos")
    //private List<Tarefa> tarefas;

}
