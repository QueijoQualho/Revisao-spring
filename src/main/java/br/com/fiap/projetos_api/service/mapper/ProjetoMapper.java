package br.com.fiap.projetos_api.service.mapper;

import br.com.fiap.projetos_api.dto.ProjetoDTO;
import br.com.fiap.projetos_api.model.Projeto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjetoMapper {

    ProjetoDTO toDto(Projeto project);
    Projeto toEntity(ProjetoDTO projectDTO);

}
