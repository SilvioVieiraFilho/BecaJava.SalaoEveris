package br.app.SalaoEveris.response;

import java.util.List;

import br.app.SalaoEveris.model.Agendamento;

public class ListAgendamentoResponse extends BaseResponse {

	private List<Agendamento> relatorio;

	public List<Agendamento> getRelatorio() {
		return relatorio;
	}

	public void setRelatorio(List<Agendamento> relatorio) {

		this.relatorio = relatorio;

	}
}
