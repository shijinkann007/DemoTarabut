package com.tarabut.demo.exceptions;

public class MissingTokenException extends Exception {

	public MissingTokenException() {
	}
	
	public MissingTokenException(String string) {
		super(string);
	}

	private static final long serialVersionUID = 1L;

}
