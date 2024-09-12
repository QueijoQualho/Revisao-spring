package br.com.fiap.projetos_api.service.mapper;

import br.com.fiap.projetos_api.dto.CentroDeCustoRequest;
import br.com.fiap.projetos_api.dto.CentroDeCustoResponse;
import br.com.fiap.projetos_api.model.CentroDeCusto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CentroDeCustoMapper {

    CentroDeCustoResponse toDto(CentroDeCusto centroDeCusto);

    @Mapping(target = "id", ignore = true)
    CentroDeCusto toEntity(CentroDeCustoRequest centroDeCustoRequest);
}
