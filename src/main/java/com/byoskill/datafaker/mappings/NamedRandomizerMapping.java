/**
 * Copyright (C) 2017-2018 Credifix
 */
package com.byoskill.datafaker.mappings;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.byoskill.datafaker.exceptions.OverridedRandomizerException;
import com.byoskill.datafaker.randomizers.Randomizer;

/**
 * The Class NamedRandomizerMapping defines a component holding the mapping
 * between names and randomizers.
 */
public class NamedRandomizerMapping {

    /** The mapping. */
    private final Map<String, Randomizer> mapping = new HashMap<>();



    /**
     * Declare a new randomizer
     *
     * @param name the name
     * @param randomizer the randomizer
     */
    public void declare(final String name, final Randomizer randomizer) {
	if (mapping.containsKey(name)) {
	    throw new OverridedRandomizerException("A randomizer with the name {0} is already present", name);
	}
	mapping.put(name, randomizer);

    }

    /**
     * Find randomizer with name.
     *
     * @param pickedRandomizer
     *            the picked randomizer
     * @return the optional
     */
    public Optional<Randomizer> findRandomizerWithName(final String pickedRandomizer) {

	return Optional.ofNullable(mapping.get(pickedRandomizer));
    }
}
