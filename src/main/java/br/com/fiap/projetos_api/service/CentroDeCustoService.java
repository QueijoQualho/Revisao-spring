package br.com.fiap.projetos_api.service;

import br.com.fiap.projetos_api.dto.CentroDeCustoRequest;
import br.com.fiap.projetos_api.dto.CentroDeCustoResponse;
import br.com.fiap.projetos_api.model.CentroDeCusto;
import br.com.fiap.projetos_api.repository.CentroDeCustoRepository;
import br.com.fiap.projetos_api.service.mapper.CentroDeCustoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CentroDeCustoService {

    @Autowired
    private CentroDeCustoRepository centroDeCustoRepository;
    @Autowired
    private CentroDeCustoMapper centroDeCustoMapper;

    @Transactional
    public CentroDeCustoResponse criarCentroDeCusto(CentroDeCustoRequest centroDeCustoRequest) {
        Optional<CentroDeCusto> optCentroDeCusto = centroDeCustoRepository.findByCodigo(centroDeCustoRequest.getCodigo());

        if(optCentroDeCusto.isPresent()) throw new IllegalArgumentException("Centro De Custo já existente");

        CentroDeCusto centroDeCusto = centroDeCustoMapper.toEntity(centroDeCustoRequest);

        centroDeCustoRepository.save(centroDeCusto);

        return centroDeCustoMapper.toDto(centroDeCusto);
    }

    public List<CentroDeCustoResponse> listarCentroDeCusto(){
        return centroDeCustoRepository.findAll().stream().map(centroDeCustoMapper::toDto).collect(Collectors.toList());
    }

    public Optional<CentroDeCustoResponse> consultarCentroDeCusto(int id) {
        return centroDeCustoRepository.findById(id).map(centroDeCustoMapper::toDto);
    }

    @Transactional
    public CentroDeCustoResponse updateCentroDeCusto(int id, CentroDeCustoRequest centroDeCustoRequest) {
        Optional<CentroDeCusto> optCentroDeCusto = centroDeCustoRepository.findById(id);

        if (optCentroDeCusto.isEmpty()) {
            throw new IllegalArgumentException("Centro De Custo não existente");
        }

        CentroDeCusto centroDeCusto = optCentroDeCusto.get();
        centroDeCusto.setNome(centroDeCustoRequest.getNome());
        centroDeCusto.setCodigo(centroDeCustoRequest.getCodigo());

        CentroDeCusto centroDeCustoSaved = centroDeCustoRepository.save(centroDeCusto);

        return centroDeCustoMapper.toDto(centroDeCustoSaved);
    }

    public void deleteCentroDeCusto(int id) {

        Optional<CentroDeCusto> optCentroDeCusto = centroDeCustoRepository.findById(id);

        if(optCentroDeCusto.isEmpty()) throw new IllegalArgumentException("Centro De Custo não existente");

        centroDeCustoRepository.delete(optCentroDeCusto.get());
    }
}
