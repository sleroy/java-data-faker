package com.byoskill.datafaker.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Marks the field as to be randomized
 * @author sleroy
 *
 */
@Documented
@Retention(RUNTIME)
@Target({ FIELD, METHOD, PARAMETER , ElementType.TYPE})
public @interface Faker {

    /**
     * Override the selection of a randomizer by picking a specific one.
     */
    String value() default "";
}
