package com.quiz.validation.constraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;

@Pattern(regexp = "\\+?[\\d\\s\\-/\\(\\)]+")
@Constraint(validatedBy = {})
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Phone {
	Class<?>[] groups() default {};

	String message() default "{cc.catalysts.cp.validation.constraints.Phone.message}";

	Class<? extends Payload>[] payload() default {};
}
