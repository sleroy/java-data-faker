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

	public String getCityName2() {
	    return cityName2;
	}

	public void setCity(final String city) {
	    this.city = city;
	}

	public void setCityName(final String cityName) {
	    this.cityName = cityName;
	}

	public void setCityName2(final String cityName2) {
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

	private String buildingNumber;

	private String city;

	private String cityName;

	private String cityPrefix;
	private String country;
	private String countryCode;
	private String firstName;
	private String lastName;
	private String latitude;
	private String longitude;
	private String secondaryAddress;
	private String state;
	private String stateAbbr;
	private String streetAddress;
	private String streetAddressNumber;
	private String streetAddressSecundary;
	private String streetSuffix;
	private String timeZone;
	private String zipCode;

	public String getBuildingNumber() {
	    return buildingNumber;
	}

	public String getCity() {
	    return city;
	}

	public String getCityName() {
	    return cityName;
	}

	public String getCityPrefix() {
	    return cityPrefix;
	}

	public String getCountry() {
	    return country;
	}

	public String getCountryCode() {
	    return countryCode;
	}

	public String getFirstName() {
	    return firstName;
	}

	public String getLastName() {
	    return lastName;
	}

	public String getLatitude() {
	    return latitude;
	}

	public String getLongitude() {
	    return longitude;
	}

	public String getSecondaryAddress() {
	    return secondaryAddress;
	}

	public String getState() {
	    return state;
	}

	public String getStateAbbr() {
	    return stateAbbr;
	}

	public String getStreetAddress() {
	    return streetAddress;
	}

	public String getStreetAddressNumber() {
	    return streetAddressNumber;
	}

	public String getStreetAddressSecundary() {
	    return streetAddressSecundary;
	}

	public String getStreetSuffix() {
	    return streetSuffix;
	}

	public String getTimeZone() {
	    return timeZone;
	}

	public String getZipCode() {
	    return zipCode;
	}

	public void setBuildingNumber(final String buildingNumber) {
	    this.buildingNumber = buildingNumber;
	}

	public void setCity(final String city) {
	    this.city = city;
	}

	public void setCityName(final String cityName) {
	    this.cityName = cityName;
	}

	public void setCityPrefix(final String cityPrefix) {
	    this.cityPrefix = cityPrefix;
	}

	public void setCountry(final String country) {
	    this.country = country;
	}

	public void setCountryCode(final String countryCode) {
	    this.countryCode = countryCode;
	}

	public void setFirstName(final String firstName) {
	    this.firstName = firstName;
	}

	public void setLastName(final String lastName) {
	    this.lastName = lastName;
	}

	public void setLatitude(final String latitude) {
	    this.latitude = latitude;
	}

	public void setLongitude(final String longitude) {
	    this.longitude = longitude;
	}

	public void setSecondaryAddress(final String secondaryAddress) {
	    this.secondaryAddress = secondaryAddress;
	}

	public void setState(final String state) {
	    this.state = state;
	}

	public void setStateAbbr(final String stateAbbr) {
	    this.stateAbbr = stateAbbr;
	}

	public void setStreetAddress(final String streetAddress) {
	    this.streetAddress = streetAddress;
	}

	public void setStreetAddressNumber(final String streetAddressNumber) {
	    this.streetAddressNumber = streetAddressNumber;
	}

	public void setStreetAddressSecundary(final String streetAddressSecundary) {
	    this.streetAddressSecundary = streetAddressSecundary;
	}

	public void setStreetSuffix(final String streetSuffix) {
	    this.streetSuffix = streetSuffix;
	}

	public void setTimeZone(final String timeZone) {
	    this.timeZone = timeZone;
	}

	public void setZipCode(final String zipCode) {
	    this.zipCode = zipCode;
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
