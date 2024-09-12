package br.com.fiap.projetos_api.controller;

import br.com.fiap.projetos_api.dto.CentroDeCustoRequest;
import br.com.fiap.projetos_api.dto.CentroDeCustoResponse;
import br.com.fiap.projetos_api.model.CentroDeCusto;
import br.com.fiap.projetos_api.service.CentroDeCustoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/centrosdecusto")
public class CentroDeCustoController {

    @Autowired
    private CentroDeCustoService centroDeCustoService;

    @PostMapping
    public ResponseEntity<?> criarCentroDeCusto(@RequestBody @Valid CentroDeCustoRequest centroDeCusto){
        CentroDeCustoResponse centroDeCustoResponseDTO = centroDeCustoService.criarCentroDeCusto(centroDeCusto);
        return new ResponseEntity<>(centroDeCustoResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CentroDeCustoResponse>> getAllCentroDeCusto(){
        return ResponseEntity.ok(centroDeCustoService.listarCentroDeCusto());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> consultarCentroDeCusto(@PathVariable int id){
        Optional<CentroDeCustoResponse> optCentroDeCusto = centroDeCustoService.consultarCentroDeCusto(id);

        if(optCentroDeCusto.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return ResponseEntity.ok(optCentroDeCusto);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<?> updateCentroDeCusto(@PathVariable int id, @RequestBody @Valid CentroDeCustoRequest centroDeCustoRequest){
            CentroDeCustoResponse centroDeCusto = centroDeCustoService.updateCentroDeCusto(id, centroDeCustoRequest);

            return new ResponseEntity<>(centroDeCusto, HttpStatus.OK);
    };

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCentroDeCusto(@PathVariable int id){
        centroDeCustoService.deleteCentroDeCusto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
