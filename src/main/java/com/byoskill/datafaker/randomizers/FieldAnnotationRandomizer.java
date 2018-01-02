/**
 * Copyright (C) 2017-2018 Credifix
 */
package com.byoskill.datafaker.randomizers;

import java.lang.annotation.Annotation;

/**
 * The Interface FieldAnnotationRandomizer defines a randomizer associated to a field annotation.
 *
 * @param <A> the generic type to define the expected annotation
 */
@FunctionalInterface
public interface FieldAnnotationRandomizer<A extends Annotation> {

    /**
     * Returns a random value for the given bean and property.
     *
     * @param bean            the bean
     * @param propertyName            the property name
     * @param annotation the annotation associated to the field
     * @return the instance or a cloned one depending of the randomizer
     *         implementation
     */
    public Object getRandomValueForFieldAnnotation(Object bean, String propertyName, A annotation);
}
