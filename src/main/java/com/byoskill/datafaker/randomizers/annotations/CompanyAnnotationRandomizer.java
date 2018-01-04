/**
 * Copyright (C) 2017-2018 Credifix
 */
package com.byoskill.datafaker.randomizers.annotations;

import com.byoskill.datafaker.annotations.Company;
import com.byoskill.datafaker.randomizers.FieldAnnotationRandomizer;
import com.byoskill.datafaker.randomizers.NamedRandomizer;
import com.byoskill.datafaker.randomizers.TypeAnnotationRandomizer;
import com.github.javafaker.Faker;

public class CompanyAnnotationRandomizer
implements TypeAnnotationRandomizer<Company>, FieldAnnotationRandomizer<Company>, NamedRandomizer {

    private final com.github.javafaker.Company rand;

    /**
     * Instantiates a new address annotation randomizer.
     *
     * @param FAKER
     *            the faker
     */
    public CompanyAnnotationRandomizer(final Faker FAKER) {

	rand = FAKER.company();
    }

    @Override
    public Object getRandomValue(final Object bean, final String propertyName) {
	Object randomValue = null;

	switch (propertyName) {
	case "companyName":
	    randomValue = rand.name();
	    break;
	default:
	    // Ignore unsupported values
	    break;
	}

	return randomValue;
    }

    @Override
    public Object getRandomValueForFieldAnnotation(final Object bean, final String propertyName,
	    final Company annotation) {
	//
	return getRandomValueFromAnnotationValue(bean,
		annotation.value().isEmpty() ? propertyName : annotation.value());
    }

    @Override
    public Object getRandomValueForTypeAnnotation(final Object bean, final String propertyName,
	    final Company annotation) {
	return getRandomValueFromAnnotationValue(bean,
		annotation.value().isEmpty() ? propertyName : annotation.value());
    }

    @Override
    public String[] getSupportedNames() {

	return new String[] {"companyName"

	};
    }

    private Object getRandomValueFromAnnotationValue(final Object bean, final String propertyName) {
	Object randomValue = null;

	switch (propertyName) {
	case "bs":
	    randomValue = rand.bs();
	    break;
	case "buzzword":
	    randomValue = rand.buzzword();
	    break;
	case "catchPhrase":
	    randomValue = rand.catchPhrase();
	    break;
	case "industry":
	    randomValue = rand.industry();
	    break;
	case "logo":
	    randomValue = rand.logo();
	    break;
	case "name":
	    randomValue = rand.name();
	    break;
	case "profession":
	    randomValue = rand.profession();
	    break;
	case "suffix":
	    randomValue = rand.suffix();
	    break;

	default:
	    // Ignore unsupported values
	    break;
	}

	return randomValue;
    }

}
