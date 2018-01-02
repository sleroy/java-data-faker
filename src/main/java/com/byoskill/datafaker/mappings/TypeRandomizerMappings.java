/**
 * Copyright (C) 2017-2018 Credifix
 */
package com.byoskill.datafaker.mappings;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.lang3.Validate;

import com.byoskill.datafaker.BeanPropertyKey;
import com.byoskill.datafaker.randomizers.Randomizer;

/**
 * The Class TypeRandomizerMappings contains the mapping between a type and a
 * specific randomizer
 */
public class TypeRandomizerMappings {

    /** The mappings. */
    private final Map<Class<?>, Randomizer> mappings = new HashMap<>();

    /**
     * Declare.
     *
     * @param implementation the implementation
     * @param randomizer the randomizer
     */
    public void declare(final Class<?> implementation, final Randomizer randomizer) {
	Validate.notNull(implementation);
	Validate.notNull(randomizer);
	mappings.put(implementation, randomizer);

    }

    /**
     * Find supported randomizer.
     *
     * @param beanPropertyKey
     *            the bean property key
     * @return the optional
     */
    public Optional<Randomizer> findSupportedRandomizer(final BeanPropertyKey beanPropertyKey) {

	return findSupportedRandomizer(beanPropertyKey.getClazz());
    }

    /**
     * Find supported randomizer.
     *
     * @param class1
     *            the class 1
     * @return the optional
     */
    public Optional<Randomizer> findSupportedRandomizer(final Class<?> class1) {

	return Optional.ofNullable(mappings.get(class1));
    }

    /**
     * Checks if is supported property.
     *
     * @param beanPropertyKey the bean property key
     * @return true, if is supported property
     */
    public boolean isSupportedProperty(final BeanPropertyKey beanPropertyKey) {

	return findSupportedRandomizer(beanPropertyKey).isPresent();
    }

    /**
     * Checks if is supported with.
     *
     * @param implementation
     *            the implementation
     * @return true, if is supported with
     */
    public boolean isSupportedWith(final Class<?> implementation) {

	return mappings.containsKey(implementation);
    }
}
