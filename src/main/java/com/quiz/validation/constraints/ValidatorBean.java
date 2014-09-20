package com.quiz.validation.constraints;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Put that annotation on any object that needs to be validated by a special bean in the
 * {@link org.springframework.context.ApplicationContext}
 *
 * @author Klaus Gieber
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface ValidatorBean {
	/**
	 * @return the name of the bean in the {@link org.springframework.context.ApplicationContext} that is responsible for
	 *         validating <code>this</code> class. the bean must implement the interface
	 *         {@link org.springframework.validation.Validator}
	 */
	String value();
}
