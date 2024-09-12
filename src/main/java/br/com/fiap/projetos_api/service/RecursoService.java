package br.com.fiap.projetos_api.service;

import br.com.fiap.projetos_api.dto.RecursoDTO;
import br.com.fiap.projetos_api.model.Recurso;
import br.com.fiap.projetos_api.repository.RecursoRepository;
import br.com.fiap.projetos_api.service.mapper.RecursoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RecursoService {

    private final RecursoRepository recursoRepository;
    private final RecursoMapper recursoMapper;

    public List<RecursoDTO> findAllRecursos() {
        return recursoRepository.findAll()
                .stream()
                .map(recursoMapper::toDto)
                .collect(Collectors.toList());
    }

    public RecursoDTO criarRecurso(RecursoDTO recursoDTO) {
        Optional<Recurso> recursoExistente = recursoRepository.findByUuid(recursoDTO.getUuid());
        if (recursoExistente.isPresent()) {
            throw new IllegalArgumentException("Recurso já existente");
        }

        Recurso recurso = recursoMapper.toEntity(recursoDTO);
        Recurso savedRecurso = recursoRepository.save(recurso);
        return recursoMapper.toDto(savedRecurso);
    }

    public Optional<RecursoDTO> buscarPorUUID(UUID uuid) {
        return recursoRepository.findByUuid(uuid).map(recursoMapper::toDto);
    }

    public RecursoDTO atualizarRecurso(RecursoDTO recursoDTO) {
        Recurso recurso = recursoMapper.toEntity(recursoDTO);
        Recurso recursoAtualizado = recursoRepository.save(recurso);
        return recursoMapper.toDto(recursoAtualizado);
    }
}
