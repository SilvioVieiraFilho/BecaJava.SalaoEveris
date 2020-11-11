package br.app.SalaoEveris.request;

import java.util.Calendar;
import java.util.Date;

import br.app.SalaoEveris.model.Cliente;
import br.app.SalaoEveris.model.Servico;

public class AgendamentoRequest {

	private Long id;

	private Servico servico;
	private Cliente cliente;

	private Date data;

	

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
