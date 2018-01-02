/**
 * Copyright (C) 2017-2018 Credifix
 */
package com.byoskill.datafaker.randomizers.annotations;

import java.lang.annotation.Annotation;

import com.byoskill.datafaker.randomizers.Randomizer;

/**
 * The Class AbstractAnnotationRandomizer defines an abstract implementation to
 * build an anontation based randomizer
 *
 * @author sleroy
 */
public abstract class AbstractAnnotationRandomizer<A extends Annotation> implements Randomizer {

    private final Class<A> annotationClass;

    /**
     * Instantiates a new abstract annotationClass randomizer.
     *
     * @param annotationClass
     *            the annotationClass
     */
    public AbstractAnnotationRandomizer(final Class<A> annotation) {
	this.annotationClass = annotation;

    }



}
