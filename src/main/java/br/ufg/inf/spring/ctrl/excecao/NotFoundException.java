package br.ufg.inf.spring.ctrl.excecao;

public class NotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public NotFoundException(String msg) {
		super(msg);
	}
}
