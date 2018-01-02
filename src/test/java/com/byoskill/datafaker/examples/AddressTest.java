package com.byoskill.datafaker.examples;

import org.junit.Test;

import com.byoskill.datafaker.PojoFaker;
import com.byoskill.datafaker.annotations.Address;
import com.byoskill.datafaker.annotations.Faker;

public class AddressTest extends AbstractFakerUnitTest {

    @Faker
    public static class AddressExample1 {

	private String city;

	private String cityName;

	public String getCity() {
	    return city;
	}

	public String getCityName() {
	    return cityName;
	}

	public void setCity(final String city) {
	    this.city = city;
	}

	public void setCityName(final String cityName) {
	    this.cityName = cityName;
	}
    }

    public static class AddressExample2 {
	@Faker
	private String city;

	@Faker
	private String cityName;


	@Faker("cityName")
	private String cityName2;

	public String getCity() {
	    return city;
	}

	public String getCityName() {
	    return cityName;
	}

	public void setCity(final String city) {
	    this.city = city;
	}

	public void setCityName(final String cityName) {
	    this.cityName = cityName;
	}

	public String getCityName2() {
	    return cityName2;
	}

	public void setCityName2(String cityName2) {
	    this.cityName2 = cityName2;
	}

    }

    public static class AddressExample3 {
	@Address("city")
	private String city;

	// overriding
	@Address("city")
	private String city2;

	@Address()
	private String cityName;

	public String getCity() {
	    return city;
	}

	public String getCity2() {
	    return city2;
	}

	public String getCityName() {
	    return cityName;
	}

	public void setCity(final String city) {
	    this.city = city;
	}

	public void setCity2(final String city2) {
	    this.city2 = city2;
	}

	public void setCityName(final String cityName) {
	    this.cityName = cityName;
	}

    }

    @Address()
    public static class AddressExample4 {

	private String city;

	private String cityName;

	private String countryCode;

	public String getCity() {
	    return city;
	}

	public String getCityName() {
	    return cityName;
	}

	public String getCountryCode() {
	    return countryCode;
	}

	public void setCity(final String city) {
	    this.city = city;
	}

	public void setCityName(final String cityName) {
	    this.cityName = cityName;
	}

	public void setCountryCode(final String countryCode) {
	    this.countryCode = countryCode;
	}

    }

    @Test
    public void testFaker() throws Exception {
	assertNoPropertyNull(PojoFaker.create().randomize(AddressExample1.class));

    }

    @Test
    public void testFaker2() throws Exception {
	assertNoPropertyNull(PojoFaker.create().randomize(AddressExample2.class));

    }

    @Test
    public void testFaker3() throws Exception {
	assertNoPropertyNull(PojoFaker.create().randomize(AddressExample3.class));

    }

    @Test
    public void testFaker4() throws Exception {
	assertNoPropertyNull(PojoFaker.create().randomize(AddressExample4.class));

    }


}
