package com.quiz.validation.constraints;



/**
 * Wrapper exception for validation violations
 */
public class ValidationViolationException extends Exception {
	protected ValidationViolationException() {
	}

	public ValidationViolationException(Throwable cause) {
		super(cause);
	}
}
