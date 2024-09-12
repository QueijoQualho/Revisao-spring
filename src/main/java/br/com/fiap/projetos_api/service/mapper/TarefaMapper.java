package br.com.fiap.projetos_api.service.mapper;

import br.com.fiap.projetos_api.dto.TarefaDTO;
import br.com.fiap.projetos_api.model.Tarefa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefaMapper {

    TarefaDTO toDto(Tarefa tarefa);
    Tarefa toEntity(TarefaDTO tarefaDTO);

}
