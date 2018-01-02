/**
 * Copyright (C) 2017-2018 Credifix
 */
package com.byoskill.datafaker.configuration;

import java.util.Locale;

import com.byoskill.datafaker.annotations.Address;
import com.byoskill.datafaker.randomizers.annotations.AddressAnnotationRandomizer;
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

	final AddressAnnotationRandomizer addressAnnotationRandomizer = new AddressAnnotationRandomizer(FAKER);
	declarations.declaresTypeAnnotationRandomizer(Address.class, addressAnnotationRandomizer);
	declarations.declaresFieldAnnotationRandomizer(Address.class, addressAnnotationRandomizer);
	declarations.declaresNamedRandomizer(addressAnnotationRandomizer);

	// Addresses,
	declarations.declaresNamedRandomizer("buildingNumber", (bean, propertyName) -> FAKER.address().buildingNumber());
	declarations.declaresNamedRandomizer("city", (bean, propertyName) -> FAKER.address().city());
	declarations.declaresNamedRandomizer("cityName", (bean, propertyName) -> FAKER.address().cityName());
	declarations.declaresNamedRandomizer("cityPrefix", (bean, propertyName) -> FAKER.address().cityPrefix());
	declarations.declaresNamedRandomizer("country", (bean, propertyName) -> FAKER.address().country());
	declarations.declaresNamedRandomizer("countryCode", (bean, propertyName) -> FAKER.address().countryCode());
	declarations.declaresNamedRandomizer("firstName", (bean, propertyName) -> FAKER.address().firstName());
	declarations.declaresNamedRandomizer("lastName", (bean, propertyName) -> FAKER.address().lastName());
	declarations.declaresNamedRandomizer("latitude", (bean, propertyName) -> FAKER.address().latitude());
	declarations.declaresNamedRandomizer("longitude", (bean, propertyName) -> FAKER.address().longitude());
	declarations.declaresNamedRandomizer("secondaryAddress", (bean, propertyName) -> FAKER.address().secondaryAddress());
	declarations.declaresNamedRandomizer("state", (bean, propertyName) -> FAKER.address().state());
	declarations.declaresNamedRandomizer("stateAbbr", (bean, propertyName) -> FAKER.address().stateAbbr());
	declarations.declaresNamedRandomizer("streetAddress", (bean, propertyName) -> FAKER.address().streetAddress());
	declarations.declaresNamedRandomizer("streetAddressNumber", (bean, propertyName) -> FAKER.address().streetAddressNumber());
	declarations.declaresNamedRandomizer("streetAddressSecundary", (bean, propertyName) -> FAKER.address().streetAddress(true));
	declarations.declaresNamedRandomizer("streetSuffix", (bean, propertyName) -> FAKER.address().streetSuffix());
	declarations.declaresNamedRandomizer("timeZone", (bean, propertyName) -> FAKER.address().timeZone());
	declarations.declaresNamedRandomizer("zipCode", (bean, propertyName) -> FAKER.address().zipCode());

    }

}
