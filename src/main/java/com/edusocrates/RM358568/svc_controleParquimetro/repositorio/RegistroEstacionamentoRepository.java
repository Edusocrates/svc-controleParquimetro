package com.edusocrates.RM358568.svc_controleParquimetro.repositorio;

import com.edusocrates.RM358568.svc_controleParquimetro.dominio.RegistroEstacionamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface RegistroEstacionamentoRepository extends JpaRepository<RegistroEstacionamento, Long> {

    @Query("SELECT r FROM RegistroEstacionamento r WHERE r.horaSaida IS NULL")
    List<RegistroEstacionamento> findEstacionadosAtualmente();

    @Query("SELECT r FROM RegistroEstacionamento r WHERE r.horaEntrada BETWEEN :start AND :end")
    List<RegistroEstacionamento> findByPeriodo(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);

    @Query("SELECT SUM(r.valorPago) FROM RegistroEstacionamento r WHERE r.horaEntrada BETWEEN :start AND :end")
    Double calcularReceitaPorPeriodo(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);
}
