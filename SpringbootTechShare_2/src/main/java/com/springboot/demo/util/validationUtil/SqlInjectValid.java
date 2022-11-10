package com.springboot.demo.util.validationUtil;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { SqlInjectValidator.class })
public @interface SqlInjectValid {
	
	String[] forbidden() default {};

	String message() default "forbidden words exist";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
