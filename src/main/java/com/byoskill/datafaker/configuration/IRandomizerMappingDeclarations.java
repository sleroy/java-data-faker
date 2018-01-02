/**
 * Copyright (C) 2017-2018 Credifix
 */
package com.byoskill.datafaker.configuration;

import java.lang.annotation.Annotation;

import com.byoskill.datafaker.BeanPropertyKey;
import com.byoskill.datafaker.randomizers.BeanPropertyRandomizer;
import com.byoskill.datafaker.randomizers.FieldAnnotationRandomizer;
import com.byoskill.datafaker.randomizers.NamedRandomizer;
import com.byoskill.datafaker.randomizers.Randomizer;
import com.byoskill.datafaker.randomizers.TypeAnnotationRandomizer;

/**
 * The Interface IRandomizerMappingDeclarations allows the devleoper to declare
 * its own randomizer configuration.
 */
public interface IRandomizerMappingDeclarations {

    /**
     * Declares a randomizer specific for a property of a bean.
     *
     * @param beanPropertyKey
     *            the bean property key
     * @param randomizer
     *            the randomizer
     */
    void declaresBeanPropertyRandomizer(BeanPropertyKey beanPropertyKey, BeanPropertyRandomizer randomizer);

    /**
     * Declares a randomizer for a given annotation.
     *
     * @param <A>
     *            the generic type
     * @param annotationClass
     *            the annotation class
     * @param randomizer
     *            the randomizer
     */
    <A extends Annotation> void declaresFieldAnnotationRandomizer(Class<A> annotationClass,
	    FieldAnnotationRandomizer<A> randomizer);

    /**
     * Declares named randomizer.
     *
     * @param addressAnnotationRandomizer
     *            the address annotation randomizer
     */
    void declaresNamedRandomizer(NamedRandomizer addressAnnotationRandomizer);

    /**
     * Adds a new named randomizer to the configuration
     *
     * @param name
     *            the name
     * @param randomizer
     *            the randomizer
     */
    void declaresNamedRandomizer(String name, Randomizer randomizer);

    /**
     * Declares type annotation randomizer.
     *
     * @param <A>
     *            the generic type
     * @param annotationClass
     *            the annotation class
     * @param annotationRandomizer
     *            the annotation randomizer
     */
    <A extends Annotation> void declaresTypeAnnotationRandomizer(Class<A> annotationClass,
	    TypeAnnotationRandomizer<A> annotationRandomizer);

    /**
     * Add a randomizer specific for a given type implementation.
     *
     * @param implementation
     *            the implementation
     * @param randomizer
     *            the randomizer
     */
    void declaresTypeRandomizer(Class<?> implementation, Randomizer randomizer);

}
