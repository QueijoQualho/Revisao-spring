package br.com.fiap.projetos_api.controller;

import br.com.fiap.projetos_api.dto.TarefaDTO;
import br.com.fiap.projetos_api.service.TarefaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/tarefas")
@AllArgsConstructor
public class TarefaController {

    private final TarefaService tarefaService;

    @PutMapping("/{uuid}")
    public ResponseEntity<?> atualizarTarefa(@RequestBody TarefaDTO tarefaDTO,
                                             @PathVariable UUID uuid) {
        try {
            tarefaDTO.setUuid(uuid);
            return new ResponseEntity<>(tarefaService.atualizarTarefa(tarefaDTO), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            // Se o tarefa não já existe, retorna 404 Not found
            return new ResponseEntity<>("Tarefa com UUID não existe.", HttpStatus.NOT_FOUND);
        }

    }
}
