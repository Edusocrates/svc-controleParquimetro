package com.edusocrates.RM358568.svc_controleParquimetro.repositorio;

import com.edusocrates.RM358568.svc_controleParquimetro.dominio.Enum.StatusVaga;
import com.edusocrates.RM358568.svc_controleParquimetro.dominio.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long> {
    List<Vaga> findByStatus(StatusVaga status);
    Optional<Vaga> findByNumero(String numero);

    @Query("SELECT COUNT(v) FROM Vaga v WHERE v.status = :status")
    long countByStatus(@Param("status") StatusVaga status);
}
