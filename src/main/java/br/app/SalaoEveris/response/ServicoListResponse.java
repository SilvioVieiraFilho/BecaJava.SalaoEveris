package br.app.SalaoEveris.response;

import java.util.List;

import br.app.SalaoEveris.model.Servico;

public class ServicoListResponse extends BaseResponse {

    private List<Servico> servico;

	public List<Servico> getServico() {
		return servico;
	}

	public void setServico(List<Servico> servico) {
		this.servico = servico;
	}



}