package br.app.SalaoEveris.response;

public class BaseResponse {
	
	public String message;
	public int statuscode;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}

	
	
	

}
