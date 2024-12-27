package com.edusocrates.RM358568.svc_controleParquimetro.repositorio;


import com.edusocrates.RM358568.svc_controleParquimetro.dominio.CapacidadeEstacionamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapacidadeEstacionamentoRepository extends JpaRepository<CapacidadeEstacionamento, Long> {
}
