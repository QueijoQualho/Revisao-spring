package br.com.fiap.projetos_api.service.mapper;

import br.com.fiap.projetos_api.dto.RecursoDTO;
import br.com.fiap.projetos_api.model.Recurso;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecursoMapper {

    RecursoDTO toDto(Recurso recurso);
    Recurso toEntity(RecursoDTO recursoDTO);

}
