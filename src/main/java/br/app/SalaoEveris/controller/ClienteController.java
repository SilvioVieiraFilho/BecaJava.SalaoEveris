package br.app.SalaoEveris.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;


import br.app.SalaoEveris.request.ClienteRequest;
import br.app.SalaoEveris.response.BaseResponse;
import br.app.SalaoEveris.response.ClienteListResponse;
import br.app.SalaoEveris.response.ClienteResponse;
import br.app.SalaoEveris.service.ClienteService;


@RestController
@RequestMapping("/clientes")



public class ClienteController  extends BaseController {
	@Autowired
    private ClienteService service;

    @PostMapping
    public ResponseEntity inserir(@RequestBody ClienteRequest request) {
        try {
            BaseResponse response = service.inserir(request);
            
            return ResponseEntity.status(response.statuscode).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(errorBase.statuscode).body(errorBase);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity obter(@PathVariable Long id) {
        try {

            ClienteResponse response = service.obter(id);
            return ResponseEntity.status(response.statuscode).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(errorBase.statuscode).body(errorBase);
        }
    }

    @GetMapping
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity listar() {
        try {
            ClienteListResponse response = service.listar();
            
            return ResponseEntity.status(response.statuscode).body(response);
            
        } catch (Exception e) {
        	
            return ResponseEntity.status(errorBase.statuscode).body(errorBase);
        }
    }
}
