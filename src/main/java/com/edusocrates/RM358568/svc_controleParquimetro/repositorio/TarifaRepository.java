package com.edusocrates.RM358568.svc_controleParquimetro.repositorio;


import com.edusocrates.RM358568.svc_controleParquimetro.dominio.Tarifa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarifaRepository extends JpaRepository<Tarifa, Long> {
}
