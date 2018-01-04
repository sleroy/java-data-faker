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
 * The Interface Color indicates a Color address to be generated. The
 * property has to be defined to specify the field. See also
 * https://dius.github.io/java-faker/apidocs/index.html
 */
@Documented
@Retention(RUNTIME)
@Target({ FIELD, METHOD, PARAMETER, ElementType.TYPE })
public @interface Color {

    /**
     * Value.
     *
     * @return the string
     */
    String value() default "";

}
