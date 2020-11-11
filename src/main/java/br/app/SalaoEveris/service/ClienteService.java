package br.app.SalaoEveris.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.app.SalaoEveris.*;
import br.app.SalaoEveris.model.*;
import br.app.SalaoEveris.repository.ClienteRepository;
import br.app.SalaoEveris.request.ClienteRequest;
import br.app.SalaoEveris.response.*;

@Service
public class ClienteService{

	@Autowired

	private ClienteRepository repository;

	public BaseResponse inserir(ClienteRequest request) {

		Cliente cliente = new Cliente();
		
		BaseResponse base = new BaseResponse();
		
		
		base.statuscode = 400;

		if (request.getCpf() == "") {

			base.message = "Erro Cpf vazio tente novamente";

			return base;
		}

		if (request.getNome() == "") {

			base.message = "Erro nome vazio tente novamente";
			return base;
		}

		if (request.getTelefone() == "") {

			base.message = "Erro telefone vazio tente novamente";

		}

		if (request.getEndereco() == "") {

			base.message = "Erro endereco vazio tente novamente";
    }

		cliente.setNome(request.getNome());
		cliente.setCpf(request.getCpf());
		cliente.setEndereco(request.getEndereco());
		cliente.setTelefone(request.getTelefone());
		
		
		
		
		repository.save(cliente);

		base.statuscode = 201;
		base.message = "Cliente cadastrado.";


		return base;
	}

	public ClienteResponse obter(Long id) {

		Optional<Cliente> cliente = repository.findById(id);

		ClienteResponse response = new ClienteResponse();
		response.statuscode = 400;

		if (!cliente.isPresent()) {

			response.message = "cliente não existente tenta novamente";

		}

		if (cliente.get().getId() == 0) {

			response.message = "cliente nao existente tente novamente";

		}
		if (cliente.get().getId() == null) {

			response.message = "id nao informado tente novamente ";

		}

		response.setId(id);
		response.setNome(cliente.get().getNome());
		response.setEndereco(cliente.get().getEndereco());
		response.setTelefone(cliente.get().getTelefone());
		response.message = "Cliente obtido.";
		response.statuscode = 200;

		return response;
	}


	
	public ClienteListResponse listar() {

        List<Cliente> lista = repository.findAll();
       
            List<ClienteResponse> listaderesposta = new ArrayList<ClienteResponse>();

            ClienteListResponse response = new  ClienteListResponse();
            ClienteResponse cliente = new ClienteResponse();

            for(Cliente c: lista) {
            	
            	
                cliente = new ClienteResponse();
                cliente.setId(c.getId());
                cliente.setEndereco(c.getEndereco());
                cliente.setTelefone(c.getTelefone());
                cliente.setNome(c.getNome());
                
                listaderesposta.add(cliente);
            
            }
            
          
           response.setClientes(listaderesposta);
           
           
        
           
        response.statuscode = 200;
        response.message = "Clientes obtidos com sucesso.";

        return response;
    }


}
















