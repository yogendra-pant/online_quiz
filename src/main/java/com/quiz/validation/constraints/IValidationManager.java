package com.quiz.validation.constraints;



/**
 * This service is able to validate objects using an own validator framework. Call
 * {@link #validate(Object)} and pass any object, if it contains invalid fields, an
 * {@link Exception} is thrown containing detailed information about all errors
 *
 * @author Klaus Gieber
 */
public interface IValidationManager {
	/**
	 * Validates the given objects
	 *
	 * @param target and object
	 * @throws ValidationViolationException if the object contains invalid fields
	 */
	void validate(Object target) throws ValidationViolationException;
}
