package br.com.fiap.projetos_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="tb_centro_custo")
@Data
public class CentroDeCusto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String codigo;
    @Column
    private String nome;
}
