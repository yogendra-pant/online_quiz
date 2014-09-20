package com.quiz.validation.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class PasswordVerificationValidator implements ConstraintValidator<PasswordVerification, Object> {
	private String passwordField;
	private String newPasswordField;
	private String confirmPasswordField;

	// --------------------- Interface ConstraintValidator ---------------------

	@Override
	public void initialize(PasswordVerification passwordVerification) {
		passwordField = passwordVerification.passwordField();
		newPasswordField = passwordVerification.newPasswordField();
		confirmPasswordField = passwordVerification.confirmPasswordField();

		String field = passwordField.substring(0, 1).toUpperCase() + passwordField.substring(1);
		if (newPasswordField.length() == 0) newPasswordField = "new" + field;
		if (confirmPasswordField.length() == 0) confirmPasswordField = "confirm" + field;
	}

	@Override
	public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
		BeanWrapper beanWrapper = new BeanWrapperImpl(o);

		String password = beanWrapper.getPropertyValue(passwordField).toString();
		String newPassword = beanWrapper.getPropertyValue(newPasswordField).toString();
		String confirmPassword = beanWrapper.getPropertyValue(confirmPasswordField).toString();

		return password != null && newPassword != null && !password.equals(newPassword) && newPassword.equals(confirmPassword);
	}
}
