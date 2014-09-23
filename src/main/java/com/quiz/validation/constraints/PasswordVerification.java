package com.quiz.validation.constraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = {PasswordVerificationValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordVerification {
	String passwordField() default "password";

	String newPasswordField() default "";

	String confirmPasswordField() default "";

	Class<?>[] groups() default {};

	String message() default "Password do not match";

	Class<? extends Payload>[] payload() default {};
}
