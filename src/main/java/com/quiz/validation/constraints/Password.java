package com.quiz.validation.constraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@NotNull
@Size(min = 6)
@Pattern(regexp = ".*([a-zA-Z]\\d|\\d[a-zA-Z]).*")
@Constraint(validatedBy = {})
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Password {
	Class<?>[] groups() default {};

	String message() default "{Password do no match}";

	Class<? extends Payload>[] payload() default {};
}
