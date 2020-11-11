package br.app.SalaoEveris.response;

import java.util.Calendar;
import java.util.Date;

import br.app.SalaoEveris.model.Cliente;
import br.app.SalaoEveris.model.Servico;

public class AgendamentoResponse extends BaseResponse{
	
	
	Long  id;
	
	
	private Date data;
	
	private Servico servico;
	
	private Cliente cliente;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
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
