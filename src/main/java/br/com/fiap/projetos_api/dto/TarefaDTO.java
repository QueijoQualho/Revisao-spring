package br.com.fiap.projetos_api.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class TarefaDTO {

    private UUID uuid;
    private String descricao;
    private int esforcoEstimado;  
  
}
