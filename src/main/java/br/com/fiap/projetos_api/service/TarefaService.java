package br.com.fiap.projetos_api.service;

import br.com.fiap.projetos_api.dto.TarefaDTO;
import br.com.fiap.projetos_api.model.Tarefa;
import br.com.fiap.projetos_api.repository.TarefaRepository;
import br.com.fiap.projetos_api.service.mapper.TarefaMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TarefaService {

    private final TarefaRepository tarefaRepository;
    private final TarefaMapper tarefaMapper;

    public Optional<TarefaDTO> buscarUUID(UUID uuid) {
       return tarefaRepository.findByUuid(uuid).map(tarefaMapper::toDto);
    }

    @Transactional
    public TarefaDTO atualizarTarefa(TarefaDTO tarefaDTO) {
        // Verificar se o tarefa já existe com base no UUID
        Optional<Tarefa> tarefaExistente = tarefaRepository.findByUuid(tarefaDTO.getUuid());
        if (tarefaExistente.isEmpty()) {
            throw new IllegalArgumentException("Tarefa com UUID não existente.");
        }
        Tarefa tarefa = tarefaMapper.toEntity(tarefaDTO);
        Tarefa savedTarefa = tarefaRepository.save(tarefa);
        return tarefaMapper.toDto(savedTarefa);
    }
}
