package br.app.SalaoEveris.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.app.SalaoEveris.model.Cliente;
import br.app.SalaoEveris.model.Servico;
import br.app.SalaoEveris.repository.ServicoRepository;
import br.app.SalaoEveris.request.ServicoRequest;
import br.app.SalaoEveris.response.*;

@Service
public class ServicoService {

	@Autowired

	private ServicoRepository repository;

	public BaseResponse inserir(ServicoRequest servicoRequest) {

		Servico servico = new Servico();

		BaseResponse base = new BaseResponse();
		base.statuscode = 400;

		if (servicoRequest.getNome() == "") {
			base.message = "Nome do serviço não informado!";
			base.statuscode = 400;
			return base;

		}

		if (servicoRequest.getValor() == 0) {
			base.message = "Valor incorreto tente novamente";
			base.statuscode = 400;
			return base;

		}

		servico.setNome(servicoRequest.getNome());
		servico.setValor(servicoRequest.getValor());

		repository.save(servico);

		base.statuscode = 201;
		base.message = "Serviço nao  cadastrado.";

		return base;

	}

	public ServicoResponse obter(Long id) {
		Optional<Servico> servico = repository.findById(id);
		ServicoResponse response = new ServicoResponse();
		response.statuscode = 400;

		if (!servico.isPresent()) {
			response.message = "Serviço não localizado!";
			return response;
		}

		if (servico.get().getId() == 0) {
			response.message = "Serviço não localizado!";
			return response;
		}

		if (servico.get().getNome() == "") {
			response.message = "Nome de serviço não localizado";
			return response;
		}

		if (servico.get().getValor() == 0) {
			response.message = "Valor de serviço não localizado!";
			return response;
		}

		response.setId(id);
		response.setNome(servico.get().getNome());
		response.setValor(servico.get().getValor());
		response.statuscode = 200;
		response.message = "Serviço obtido com sucesso!";
		return response;
	}

	public ServicoListResponse listar() {

		List<Servico> lista = repository.findAll();

		ServicoListResponse response = new ServicoListResponse();

		response.setServico(lista);
		response.statuscode = 200;
		response.message = "Serviços obtidos com sucesso.";

		return response;

	}

}
