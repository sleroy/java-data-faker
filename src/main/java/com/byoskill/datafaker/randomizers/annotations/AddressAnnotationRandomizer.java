/**
 * Copyright (C) 2017-2018 Credifix
 */
package com.byoskill.datafaker.randomizers.annotations;

import com.byoskill.datafaker.annotations.Address;
import com.byoskill.datafaker.randomizers.FieldAnnotationRandomizer;
import com.byoskill.datafaker.randomizers.NamedRandomizer;
import com.byoskill.datafaker.randomizers.TypeAnnotationRandomizer;
import com.github.javafaker.Faker;

public class AddressAnnotationRandomizer
implements TypeAnnotationRandomizer<Address>, FieldAnnotationRandomizer<Address>, NamedRandomizer {

    private final com.github.javafaker.Address rand;

    /**
     * Instantiates a new address annotation randomizer.
     *
     * @param FAKER
     *            the faker
     */
    public AddressAnnotationRandomizer(final Faker FAKER) {

	rand = FAKER.address();
    }

    @Override
    public Object getRandomValue(final Object bean, final String propertyName) {
	Object randomValue = null;

	switch (propertyName) {
	case "buildingNumber":
	    randomValue = rand.buildingNumber();
	    break;
	case "city":
	    randomValue = rand.city();
	    break;
	case "cityName":
	    randomValue = rand.cityName();
	    break;
	case "cityPrefix":
	    randomValue = rand.cityPrefix();
	    break;
	case "country":
	    randomValue = rand.country();
	    break;
	case "countryCode":
	    randomValue = rand.countryCode();
	    break;
	case "firstName":
	    randomValue = rand.firstName();
	    break;
	case "lastName":
	    randomValue = rand.lastName();
	    break;
	case "latitude":
	    randomValue = rand.latitude();
	    break;
	case "longitude":
	    randomValue = rand.longitude();
	    break;
	case "secondaryAddress":
	    randomValue = rand.secondaryAddress();
	    break;
	case "state":
	    randomValue = rand.state();
	    break;
	case "stateAbbr":
	    randomValue = rand.stateAbbr();
	    break;
	case "streetAddress":
	    randomValue = rand.streetAddress();
	    break;
	case "streetAddressNumber":
	    randomValue = rand.streetAddressNumber();
	    break;
	case "streetAddressSecundary":
	    randomValue = rand.streetAddress(true);
	    break;
	case "streetSuffix":
	    randomValue = rand.streetSuffix();
	    break;
	case "timeZone":
	    randomValue = rand.timeZone();
	    break;
	case "zipCode":
	    randomValue = rand.zipCode();
	    break;
	default:
	    // Ignore unsupported values
	    break;
	}

	return randomValue;
    }

    @Override
    public Object getRandomValue(final Object bean, final String propertyName, final Address annotation) {
	//
	return getRandomValue(bean, annotation.value().isEmpty() ? propertyName : annotation.value());
    }

    @Override
    public String[] getSupportedNames() {

	return new String[] {
		"buildingNumber",
		"city",
		"cityName",
		"cityPrefix",
		"country",
		"countryCode",
		"firstName",
		"lastName",
		"latitude",
		"longitude",
		"secondaryAddress",
		"state",
		"stateAbbr",
		"streetAddress",
		"streetAddressNumber",
		"streetAddressSecundary",
		"streetSuffix",
		"timeZone",
		"zipCode"

	};
    }

}
