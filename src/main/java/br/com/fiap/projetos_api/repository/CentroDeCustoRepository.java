package br.com.fiap.projetos_api.repository;

import br.com.fiap.projetos_api.model.CentroDeCusto;
import br.com.fiap.projetos_api.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CentroDeCustoRepository extends JpaRepository<CentroDeCusto, Integer> {
    Optional<CentroDeCusto> findByCodigo(String codigo);
}
