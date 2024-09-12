package br.com.fiap.projetos_api.dto;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Data;

@Data
public class RecursoDTO {

    private UUID uuid;
    private String nome;
    private BigDecimal valorHora;

}
