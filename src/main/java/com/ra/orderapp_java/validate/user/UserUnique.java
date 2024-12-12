package com.ra.orderapp_java.validate.user;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UserValidate.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserUnique {
    String message() default "email duplicate entry";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}