/**
 * Copyright (C) 2017-2018 Credifix
 */
package com.byoskill.datafaker.mappings;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import com.byoskill.datafaker.BeanPropertyKey;
import com.byoskill.datafaker.FakerBeanUtils;
import com.byoskill.datafaker.exceptions.OverridedRandomizerException;
import com.byoskill.datafaker.randomizers.FieldAnnotationRandomizerImpl;
import com.byoskill.datafaker.randomizers.FieldAnnotationRandomizer;
import com.byoskill.datafaker.randomizers.Randomizer;

public class FieldAnnotationMappings {

    private final Map<Class<? extends Annotation>, Randomizer> mapping = new HashMap<>();

    /**
     * Declare a new randomizer for a specific annotation.
     *
     * @param annotationClass
     *            the annotation class
     * @param randomizer
     *            the random function
     */
    public <A extends Annotation> void declare(final Class<A> annotationClass,
	    final FieldAnnotationRandomizer<A> randomizer) {
	if (mapping.containsKey(annotationClass)) {
	    throw new OverridedRandomizerException("A randomizer for the annotation {0} is already present",
		    annotationClass);
	}
	mapping.put(annotationClass, new FieldAnnotationRandomizerImpl(annotationClass, randomizer));
    }

    /**
     * Find a supported randomizer.
     *
     * @param beanPropertyKey
     *            the bean property key
     * @return the optional
     */
    public Optional<Randomizer> findSupportedRandomizer(final BeanPropertyKey beanPropertyKey) {

	for (final Entry<Class<? extends Annotation>, Randomizer> annotationMapping : mapping.entrySet()) {
	    if (FakerBeanUtils.findAnnotation(beanPropertyKey, annotationMapping.getKey()).isPresent()) {
		return Optional.ofNullable(annotationMapping.getValue());
	    }
	}

	return Optional.empty();
    }

}
