package br.app.SalaoEveris.service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.app.SalaoEveris.model.Agendamento;
import br.app.SalaoEveris.model.Cliente;
import br.app.SalaoEveris.model.Servico;
import br.app.SalaoEveris.repository.AgendamentoRepository;
import br.app.SalaoEveris.repository.ClienteRepository;
import br.app.SalaoEveris.repository.ServicoRepository;
import br.app.SalaoEveris.request.AgendamentoRequest;
import br.app.SalaoEveris.request.ServicoRequest;
import br.app.SalaoEveris.response.BaseResponse;
import br.app.SalaoEveris.response.ListAgendamentoResponse;
import br.app.SalaoEveris.response.ServicoListResponse;

@Service
public class AgendamentoService {

	@Autowired
	private AgendamentoRepository repository;

	@Autowired
	private ServicoRepository _repository;
	@Autowired
	private ClienteRepository _crepository;
	@Autowired
	private AgendamentoRepository arepository;

	public BaseResponse inserir(AgendamentoRequest request) {

//		Cliente clientel = _crepository.findByid(request.getServico().getId());
//
//		Optional<Servico> servicolista = _repository.findById(request.getServico().getId());

		Cliente cliente = new Cliente();
		Servico servico = new Servico();

		Agendamento agendamento = new Agendamento();

		BaseResponse base = new BaseResponse();

		if (request.getData() == null) {
			base.message = "Erro, digita a data.";
			base.statuscode = 400;
			return base;
		}

		if (request.getCliente() == null) {
			base.message = "Erro, digite id.";
			base.statuscode = 400;
			return base;

		}

		agendamento.setData(request.getData());
		agendamento.setCliente(request.getCliente());
		agendamento.setServico(request.getServico());

		// operacao.setValor(operacaoSpec.getValor());
		// operacao.setTipo(operacaoSpec.getTipo());

		repository.save(agendamento);

		base.message = "Servico registrado.";
		base.statuscode = 201;
		return base;
	}

//	public ListAgendamentoResponse relatorio(Timestamp dataInicio, Timestamp dataFim) {
//
//		Calendar dtInicio = Calendar.getInstance();
//		dtInicio.setTime(dataInicio);
//
//		Calendar dtFim = Calendar.getInstance();
//		dtFim.setTime(dataFim);
//
//		ListAgendamentoResponse relatorio = new ListAgendamentoResponse();
//
//		relatorio.setRelatorio(arepository.findBuscarAgendamentos(dtInicio, dtFim));
//		relatorio.statuscode = 200;
//		relatorio.message = "Estou com sono";
//
//		return relatorio;
//	}

}

// OBTER RELATORIO
