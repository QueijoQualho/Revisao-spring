package br.com.fiap.projetos_api.repository;

import br.com.fiap.projetos_api.model.Recurso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
import java.util.Optional;

public interface RecursoRepository extends JpaRepository<Recurso, UUID> {
    Optional<Recurso> findByUuid(UUID uuid);
}
