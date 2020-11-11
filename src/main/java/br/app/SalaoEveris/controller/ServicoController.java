package br.app.SalaoEveris.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import br.app.SalaoEveris.request.ClienteRequest;
import br.app.SalaoEveris.request.ServicoRequest;
import br.app.SalaoEveris.response.BaseResponse;
import br.app.SalaoEveris.response.ClienteListResponse;
import br.app.SalaoEveris.response.ClienteResponse;
import br.app.SalaoEveris.response.ServicoListResponse;
import br.app.SalaoEveris.response.ServicoResponse;
import br.app.SalaoEveris.service.ServicoService;

@RestController
@RequestMapping("/servico")

public class ServicoController extends BaseController {
	@Autowired

	private ServicoService service;

	@PostMapping
	public ResponseEntity inserir(@RequestBody ServicoRequest request) {
		try {
			BaseResponse response = service.inserir(request);

			return ResponseEntity.status(response.getStatuscode()).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.getStatuscode()).body(errorBase);
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity obter(@PathVariable Long id) {
		try {

			ServicoResponse response = service.obter(id);
			return ResponseEntity.status(response.getStatuscode()).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.getStatuscode()).body(errorBase);
		}
	}

	@GetMapping
	public ResponseEntity listar() {

		try {
			ServicoListResponse response = service.listar();

			return ResponseEntity.status(response.getStatuscode()).body(response);

		} catch (Exception e) {

			return ResponseEntity.status(errorBase.getStatuscode()).body(errorBase);
		}
	}

}
