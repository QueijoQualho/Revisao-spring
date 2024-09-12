package br.com.fiap.projetos_api.repository;

import br.com.fiap.projetos_api.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
import java.util.Optional;

public interface TarefaRepository extends JpaRepository<Tarefa, UUID> {
  Optional<Tarefa> findByUuid(UUID uuid);

}
