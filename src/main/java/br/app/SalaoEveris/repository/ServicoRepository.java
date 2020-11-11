package br.app.SalaoEveris.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.app.SalaoEveris.model.Cliente;
import br.app.SalaoEveris.model.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long> {

}
