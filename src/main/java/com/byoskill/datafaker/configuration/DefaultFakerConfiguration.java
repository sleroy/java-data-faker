/**
 * Copyright (C) 2017-2018 Credifix
 */
package com.byoskill.datafaker.configuration;

import java.util.Locale;

import com.byoskill.datafaker.annotations.Address;
import com.byoskill.datafaker.annotations.Color;
import com.byoskill.datafaker.randomizers.annotations.AddressAnnotationRandomizer;
import com.byoskill.datafaker.randomizers.annotations.ColorAnnotationRandomizer;
import com.github.javafaker.Faker;

public class DefaultFakerConfiguration extends FakerConfiguration {


    private final Faker FAKER;
    private final Locale locale;

    /**
     * Instantiates a new default faker configuration.
     */
    public DefaultFakerConfiguration() {
	this(Locale.getDefault());
    }

    /**
     * Instantiates a new default faker configuration.
     *
     * @param locale the locale
     */
    public DefaultFakerConfiguration(final Locale locale) {
	super();
	this.locale = locale;
	FAKER = Faker.instance(locale);
    }

    @Override
    public void init(final IRandomizerMappingDeclarations declarations) {

	declarations.declaresAnnotationRandomizer(Address.class, new AddressAnnotationRandomizer(FAKER));
	declarations.declaresAnnotationRandomizer(Color.class, new ColorAnnotationRandomizer(FAKER));


    }

}
