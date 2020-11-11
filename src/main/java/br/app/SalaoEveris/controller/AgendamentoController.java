package br.app.SalaoEveris.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.app.SalaoEveris.request.AgendamentoRequest;
import br.app.SalaoEveris.response.AgendamentoResponse;
import br.app.SalaoEveris.response.BaseResponse;
import br.app.SalaoEveris.response.ClienteResponse;
import br.app.SalaoEveris.response.ListAgendamentoResponse;
import br.app.SalaoEveris.service.AgendamentoService;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController extends BaseController {
	@Autowired
	private AgendamentoService service;

	@PostMapping
	public ResponseEntity inserir(@RequestBody AgendamentoRequest request) {
		try {
			BaseResponse response = service.inserir(request);
			return ResponseEntity.status(response.statuscode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statuscode).body(errorBase);
		}

	}

}
