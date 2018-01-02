/**
 * Copyright (C) 2017-2018 Credifix
 */
package com.byoskill.datafaker.mappings;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.byoskill.datafaker.BeanPropertyKey;
import com.byoskill.datafaker.exceptions.OverridedRandomizerException;
import com.byoskill.datafaker.randomizers.BeanPropertyRandomizer;
import com.byoskill.datafaker.randomizers.Randomizer;

/**
 * The Class BeanPropertyRandomizerMappings offers the possibility to map a
 * randomizer to a specific bean property.
 */
public class BeanPropertyRandomizerMappings {

    /** The mappings. */
    private final Map<BeanPropertyKey, Randomizer> mappings = new HashMap<>();

    /**
     * Declare the bean property randomizer.
     *
     * @param name
     *            the name
     * @param randomizer
     *            the randomizer
     */
    public void declare(final BeanPropertyKey beanPropertyKey, final BeanPropertyRandomizer randomizer) {
	if (mappings.containsKey(beanPropertyKey)) {
	    throw new OverridedRandomizerException("A randomizer associated with {0} is already present",
		    beanPropertyKey);
	}
	mappings.put(beanPropertyKey, (bean, propertyName) -> randomizer.getRandomValue(BeanPropertyKey.of(bean, propertyName)) );

    }

    /**
     * Find randomizer with name.
     *
     * @param beanPropertyKey
     *            the bean property key
     * @return the optional
     */
    public Optional<Randomizer> findSupportedRandomizer(final BeanPropertyKey beanPropertyKey) {

	return Optional.ofNullable(mappings.get(beanPropertyKey));
    }

    /**
     * Checks if is supported mapping.
     *
     * @param beanPropertyKey the bean property key
     * @return true, if is supported mapping
     */
    public boolean isSupportedMapping(final BeanPropertyKey beanPropertyKey) {

	return mappings.containsKey(beanPropertyKey);
    }

}
