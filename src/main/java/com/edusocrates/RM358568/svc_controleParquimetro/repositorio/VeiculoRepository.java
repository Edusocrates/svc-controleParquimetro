package com.edusocrates.RM358568.svc_controleParquimetro.repositorio;

import com.edusocrates.RM358568.svc_controleParquimetro.dominio.Enum.Status;
import com.edusocrates.RM358568.svc_controleParquimetro.dominio.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    List<Veiculo> findByVagaId(Long vagaId);
    List<Veiculo> findByStatus(Status status);
}
