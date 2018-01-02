/**
 * Copyright (C) 2017-2018 Credifix
 */
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
 * The Interface Address indicates a Random address to be generated. The
 * property has to be defined to specify the field. See also
 * https://dius.github.io/java-faker/apidocs/index.html
 */
@Documented
@Retention(RUNTIME)
@Target({ FIELD, METHOD, PARAMETER, ElementType.TYPE })
public @interface Address {

    /**
     * Value.
     *
     * @return the string
     */
    String value() default "";

}
