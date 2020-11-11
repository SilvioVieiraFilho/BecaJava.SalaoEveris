package br.app.SalaoEveris.repository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.app.SalaoEveris.model.Agendamento;



public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
	
	@Query(value = "EXEC SP_BuscarAgendamentos :dataInicio, :dataFim", nativeQuery = true)
    List<Agendamento> findBuscarAgendamentos(@Param("dataInicio") Calendar dataInicio,
            @Param("dataFim") Calendar dataFim);

}
