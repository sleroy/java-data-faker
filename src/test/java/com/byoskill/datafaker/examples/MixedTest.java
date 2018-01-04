package com.byoskill.datafaker.examples;

import org.junit.Test;

import com.byoskill.datafaker.PojoFaker;
import com.byoskill.datafaker.annotations.Address;
import com.byoskill.datafaker.annotations.Business;
import com.byoskill.datafaker.annotations.Color;
import com.byoskill.datafaker.annotations.Faker;

public class MixedTest extends AbstractFakerUnitTest {

    @Faker
    public static class MixedExample1 {

	private String cityName;

	private String colorName;

	private String creditCardExpiry;

	public String getCityName() {
	    return cityName;
	}

	public String getColorName() {
	    return colorName;
	}

	public String getCreditCardExpiry() {
	    return creditCardExpiry;
	}

	public void setCityName(final String cityName) {
	    this.cityName = cityName;
	}

	public void setColorName(final String colorName) {
	    this.colorName = colorName;
	}

	public void setCreditCardExpiry(final String creditCardExpiry) {
	    this.creditCardExpiry = creditCardExpiry;
	}

    }

    public static class MixedExample2 {

	@Faker
	private String cityName;

	@Faker
	private String colorName;

	@Faker
	private String creditCardExpiry;

	public String getCityName() {
	    return cityName;
	}

	public String getColorName() {
	    return colorName;
	}

	public String getCreditCardExpiry() {
	    return creditCardExpiry;
	}

	public void setCityName(final String cityName) {
	    this.cityName = cityName;
	}

	public void setColorName(final String colorName) {
	    this.colorName = colorName;
	}

	public void setCreditCardExpiry(final String creditCardExpiry) {
	    this.creditCardExpiry = creditCardExpiry;
	}

    }

    public static class MixedExample3 {

	@Address
	private String cityName;

	@Business
	private String creditCardExpiry;

	@Color
	private String name;

	public String getCityName() {
	    return cityName;
	}

	public String getCreditCardExpiry() {
	    return creditCardExpiry;
	}

	public String getName() {
	    return name;
	}

	public void setCityName(final String cityName) {
	    this.cityName = cityName;
	}

	public void setCreditCardExpiry(final String creditCardExpiry) {
	    this.creditCardExpiry = creditCardExpiry;
	}

	public void setName(final String name) {
	    this.name = name;
	}
    }



    @Test
    public void testFaker() throws Exception {
	assertNoPropertyNull(PojoFaker.create().randomize(MixedExample1.class));

    }

    @Test
    public void testFaker2() throws Exception {
	assertNoPropertyNull(PojoFaker.create().randomize(MixedExample2.class));

    }

    @Test
    public void testFaker3() throws Exception {
	assertNoPropertyNull(PojoFaker.create().randomize(MixedExample3.class));

    }



}
