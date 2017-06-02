package br.edu.ifpb.mt.tt;

public class TecnicasDeTesteException extends Exception {

	private static final long serialVersionUID = -2405733399860387290L;

	public TecnicasDeTesteException(String message) {
		super(message);
	}

	public TecnicasDeTesteException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
