package eep.sippr.eepj.service.exception;

import java.io.Serializable;

public class SampleException extends RuntimeException implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public SampleException() {
		super();
	}

	public SampleException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
	}

	public SampleException(String message) {
		super(message);
		this.message = message;
	}

	public SampleException(Throwable cause) {
		super(cause);
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
