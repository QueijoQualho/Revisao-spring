package br.com.fiap.projetos_api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CentroDeCustoRequest {

    @NotBlank
    private String codigo;
    @NotBlank
    private String nome;

}
