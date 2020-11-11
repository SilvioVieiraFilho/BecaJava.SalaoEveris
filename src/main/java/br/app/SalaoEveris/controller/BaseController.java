package br.app.SalaoEveris.controller;

import br.app.SalaoEveris.response.BaseResponse;

public class BaseController {

	public BaseResponse errorBase = new BaseResponse();

	public BaseController() {
		errorBase.statuscode = 500;
		errorBase.message = "Erro inesperado";

	}
}
