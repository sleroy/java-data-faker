/**
 * Copyright (C) 2017-2018 Credifix
 */
package com.byoskill.datafaker.mappings;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import com.byoskill.datafaker.exceptions.OverridedRandomizerException;
import com.byoskill.datafaker.randomizers.Randomizer;
import com.byoskill.datafaker.randomizers.TypeAnnotationRandomizer;

public class TypeAnnotationMappings {

    private final Map<Class<? extends Annotation>, Randomizer> mapping = new HashMap<>();

    /**
     * Declare a new randomizer for a specific annotation.
     *
     * @param annotationClass
     *            the annotation class
     * @param annotationRandomizer
     *            the random function
     */
    public <A extends Annotation> void declare(final Class<A> annotationClass,
	    final TypeAnnotationRandomizer<A> annotationRandomizer) {
	if (mapping.containsKey(annotationClass)) {
	    throw new OverridedRandomizerException("A randomizer for the annotation {0} is already present",
		    annotationClass);
	}
	mapping.put(annotationClass, (bean, propertyName) -> annotationRandomizer.getRandomValueForTypeAnnotation(bean, propertyName,
		bean.getClass().getAnnotation(annotationClass)));
    }

    /**
     * Find a supported randomizer.
     *
     * @param class1
     *            the bean property key
     * @return the optional
     */
    public Optional<Randomizer> findSupportedRandomizer(final Class<? extends Object> class1) {

	for (final Entry<Class<? extends Annotation>, Randomizer> annotationMapping : mapping.entrySet()) {
	    if (class1.isAnnotationPresent(annotationMapping.getKey())) {
		return Optional.ofNullable(annotationMapping.getValue());
	    }
	}

	return Optional.empty();
    }

    /**
     * Checks if is supported by.
     *
     * @param implementation the implementation
     * @return true, if is supported by
     */
    public boolean isSupportedBy(final Class<?> implementation) {
	for (final Class<? extends Annotation> annotationImpl : mapping.keySet()) {
	    if (implementation.isAnnotationPresent(annotationImpl)) {
		return true;
	    }
	}
	return false;
    }

}
