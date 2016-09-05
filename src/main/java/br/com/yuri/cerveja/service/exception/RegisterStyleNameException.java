package br.com.yuri.cerveja.service.exception;

public class RegisterStyleNameException extends RuntimeException {

	private static final long serialVersionUID = 7323224421371796165L;
	
	public RegisterStyleNameException(String message){
		super(message);
	}
}
