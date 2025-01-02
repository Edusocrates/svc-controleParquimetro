package com.edusocrates.RM358568.svc_controleParquimetro.infraestrutura.repositorio;

import com.edusocrates.RM358568.svc_controleParquimetro.dominio.Enum.Status;
import com.edusocrates.RM358568.svc_controleParquimetro.dominio.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    List<Veiculo> findByVagaId(Long vagaId);
    List<Veiculo> findByStatus(Status status);
}
