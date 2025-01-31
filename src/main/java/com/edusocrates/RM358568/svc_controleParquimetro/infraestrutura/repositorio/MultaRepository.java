package com.edusocrates.RM358568.svc_controleParquimetro.infraestrutura.repositorio;

import com.edusocrates.RM358568.svc_controleParquimetro.dominio.model.Multa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MultaRepository extends JpaRepository<Multa, Long> {
    List<Multa> findByVeiculoId(Long veiculoId);
}
