/**
 * Copyright (C) 2017-2018 Credifix
 */
package com.byoskill.datafaker.randomizers;

import java.lang.annotation.Annotation;
import java.util.Optional;

import com.byoskill.datafaker.BeanPropertyKey;
import com.byoskill.datafaker.FakerBeanUtils;

/**
 * The Class AnnotationRandomizer declares the implementation of an Field
 * Annotation Randomizer
 *
 * @param <A>
 *            the generic type
 */
public class FieldAnnotationRandomizerImpl<A extends Annotation> implements Randomizer {

    private final Class<A>		       annotationClass;
    private final FieldAnnotationRandomizer<A> randomizer;

    /**
     * Instantiates a new annotation randomizer.
     *
     * @param annotationClass
     *            the annotation class
     * @param randomizer
     *            the randomizer
     */
    public FieldAnnotationRandomizerImpl(final Class<A> annotationClass,
	    final FieldAnnotationRandomizer<A> randomizer) {
	this.annotationClass = annotationClass;
	this.randomizer = randomizer;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.byoskill.datafaker.randomizers.Randomizer#getRandomValue(java.lang.
     * Object, java.lang.String)
     */
    @Override
    public final Object getRandomValue(final Object bean, final String propertyName) {
	final Optional<A> annotation = FakerBeanUtils.findAnnotation(BeanPropertyKey.of(bean, propertyName),
		annotationClass);
	return randomizer.getRandomValue(bean, propertyName, annotation.get());
    }

}
