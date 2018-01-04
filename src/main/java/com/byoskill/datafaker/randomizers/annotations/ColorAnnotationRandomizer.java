/**
 * Copyright (C) 2017-2018 Credifix
 */
package com.byoskill.datafaker.randomizers.annotations;

import com.byoskill.datafaker.annotations.Color;
import com.byoskill.datafaker.randomizers.FieldAnnotationRandomizer;
import com.byoskill.datafaker.randomizers.NamedRandomizer;
import com.byoskill.datafaker.randomizers.TypeAnnotationRandomizer;
import com.github.javafaker.Faker;

public class ColorAnnotationRandomizer
implements TypeAnnotationRandomizer<Color>, FieldAnnotationRandomizer<Color>, NamedRandomizer {

    private final com.github.javafaker.Color rand;

    /**
     * Instantiates a new address annotation randomizer.
     *
     * @param FAKER
     *            the faker
     */
    public ColorAnnotationRandomizer(final Faker FAKER) {

	rand = FAKER.color();
    }

    @Override
    public Object getRandomValue(final Object bean, final String propertyName) {
	Object randomValue = null;

	switch (propertyName) {
	case "colorName":
	    randomValue = rand.name();
	    break;
	default:
	    // Ignore unsupported values
	    break;
	}

	return randomValue;
    }


    @Override
    public Object getRandomValueForFieldAnnotation(final Object bean, final String propertyName, final Color annotation) {
	//
	return getRandomValueFromAnnotationValue(bean, annotation.value().isEmpty() ? propertyName : annotation.value());
    }

    @Override
    public Object getRandomValueForTypeAnnotation(final Object bean, final String propertyName,
	    final Color annotation) {
	return getRandomValueFromAnnotationValue(bean, annotation.value().isEmpty() ? propertyName : annotation.value());
    }

    @Override
    public String[] getSupportedNames() {

	return new String[] { "colorName",

	};
    }

    private Object getRandomValueFromAnnotationValue(final Object bean, final String propertyName) {
	Object randomValue = null;

	switch (propertyName) {
	case "name":
	    randomValue = rand.name();
	    break;
	default:
	    // Ignore unsupported values
	    break;
	}

	return randomValue;
    }

}
