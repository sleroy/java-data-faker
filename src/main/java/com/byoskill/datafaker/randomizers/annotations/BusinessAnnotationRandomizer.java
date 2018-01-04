/**
 * Copyright (C) 2017-2018 Credifix
 */
package com.byoskill.datafaker.randomizers.annotations;

import com.byoskill.datafaker.annotations.Business;
import com.byoskill.datafaker.randomizers.FieldAnnotationRandomizer;
import com.byoskill.datafaker.randomizers.NamedRandomizer;
import com.byoskill.datafaker.randomizers.TypeAnnotationRandomizer;
import com.github.javafaker.Faker;

public class BusinessAnnotationRandomizer
implements TypeAnnotationRandomizer<Business>, FieldAnnotationRandomizer<Business>, NamedRandomizer {

    private final com.github.javafaker.Business rand;

    /**
     * Instantiates a new address annotation randomizer.
     *
     * @param FAKER
     *            the faker
     */
    public BusinessAnnotationRandomizer(final Faker FAKER) {

	rand = FAKER.business();
    }

    @Override
    public Object getRandomValue(final Object bean, final String propertyName) {
	Object randomValue = null;

	switch (propertyName) {
	case "creditCardExpiry":
	    randomValue = rand.creditCardExpiry();
	    break;
	case "creditCardNumber":
	    randomValue = rand.creditCardNumber();
	    break;
	case "creditCardType":
	    randomValue = rand.creditCardType();
	    break;
	default:
	    // Ignore unsupported values
	    break;
	}

	return randomValue;
    }

    @Override
    public Object getRandomValueForFieldAnnotation(final Object bean, final String propertyName,
	    final Business annotation) {
	//
	return getRandomValue(bean, annotation.value().isEmpty() ? propertyName : annotation.value());
    }

    @Override
    public Object getRandomValueForTypeAnnotation(final Object bean, final String propertyName,
	    final Business annotation) {
	return getRandomValue(bean, annotation.value().isEmpty() ? propertyName : annotation.value());
    }

    @Override
    public String[] getSupportedNames() {

	return new String[] { "creditCardType", "creditCardNumber", "creditCardExpiry"

	};
    }

}
