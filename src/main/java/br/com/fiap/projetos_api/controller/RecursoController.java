package br.com.fiap.projetos_api.controller;


import br.com.fiap.projetos_api.dto.RecursoDTO;
import br.com.fiap.projetos_api.service.RecursoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/recursos")
@AllArgsConstructor
public class RecursoController {

    private final RecursoService recursoService;

    @GetMapping
    public ResponseEntity<List<RecursoDTO>> findAllRecursos(){
        return ResponseEntity.ok(recursoService.findAllRecursos());
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<RecursoDTO> find(@PathVariable UUID uuid){
        Optional<RecursoDTO> recursoDTO = recursoService.buscarPorUUID(uuid);
        return recursoDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createRecurso(@RequestBody RecursoDTO recursoDTO) {
        try {
            RecursoDTO novoRecursoDTO = recursoService.criarRecurso(recursoDTO);
            return new ResponseEntity<>(novoRecursoDTO, HttpStatus.CREATED);
        } catch(IllegalArgumentException e) {
            return new ResponseEntity<>("Recurso com UUID já existe", HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<RecursoDTO> update(@PathVariable UUID uuid, @RequestBody RecursoDTO recursoDTO){
        Optional<RecursoDTO> recursoExistenteDTO = recursoService.buscarPorUUID(uuid);
        if (recursoExistenteDTO.isPresent()){
            recursoDTO.setUuid(uuid);
            RecursoDTO recursoDTOatualizado = recursoService.atualizarRecurso(recursoDTO);
            return  new ResponseEntity<>(recursoDTOatualizado, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
