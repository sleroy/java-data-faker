package com.byoskill.datafaker.examples;

import org.junit.Test;

import com.byoskill.datafaker.PojoFaker;
import com.byoskill.datafaker.annotations.Business;
import com.byoskill.datafaker.annotations.Faker;

public class BusinessTest extends AbstractFakerUnitTest {

    @Faker
    public static class BusinessExample1 {

	private String creditCardExpiry;
	private String creditCardNumber;
	private String creditCardType;
	public String getCreditCardExpiry() {
	    return creditCardExpiry;
	}
	public String getCreditCardNumber() {
	    return creditCardNumber;
	}
	public String getCreditCardType() {
	    return creditCardType;
	}
	public void setCreditCardExpiry(final String creditCardExpiry) {
	    this.creditCardExpiry = creditCardExpiry;
	}
	public void setCreditCardNumber(final String creditCardNumber) {
	    this.creditCardNumber = creditCardNumber;
	}
	public void setCreditCardType(final String creditCardType) {
	    this.creditCardType = creditCardType;
	}

    }

    public static class BusinessExample2 {

	@Faker
	private String creditCardExpiry;
	@Faker
	private String creditCardNumber;
	@Faker
	private String creditCardType;
	public String getCreditCardExpiry() {
	    return creditCardExpiry;
	}
	public String getCreditCardNumber() {
	    return creditCardNumber;
	}
	public String getCreditCardType() {
	    return creditCardType;
	}
	public void setCreditCardExpiry(final String creditCardExpiry) {
	    this.creditCardExpiry = creditCardExpiry;
	}
	public void setCreditCardNumber(final String creditCardNumber) {
	    this.creditCardNumber = creditCardNumber;
	}
	public void setCreditCardType(final String creditCardType) {
	    this.creditCardType = creditCardType;
	}

    }

    public static class BusinessExample3 {

	@Business
	private String creditCardExpiry;

	@Business
	private String creditCardNumber;

	@Business
	private String creditCardType;

	public String getCreditCardExpiry() {
	    return creditCardExpiry;
	}

	public String getCreditCardNumber() {
	    return creditCardNumber;
	}

	public String getCreditCardType() {
	    return creditCardType;
	}

	public void setCreditCardExpiry(final String creditCardExpiry) {
	    this.creditCardExpiry = creditCardExpiry;
	}

	public void setCreditCardNumber(final String creditCardNumber) {
	    this.creditCardNumber = creditCardNumber;
	}

	public void setCreditCardType(final String creditCardType) {
	    this.creditCardType = creditCardType;
	}
    }

    @Business
    public static class BusinessExample4 {

	private String creditCardExpiry;
	private String creditCardNumber;
	private String creditCardType;
	public String getCreditCardExpiry() {
	    return creditCardExpiry;
	}
	public String getCreditCardNumber() {
	    return creditCardNumber;
	}
	public String getCreditCardType() {
	    return creditCardType;
	}
	public void setCreditCardExpiry(final String creditCardExpiry) {
	    this.creditCardExpiry = creditCardExpiry;
	}
	public void setCreditCardNumber(final String creditCardNumber) {
	    this.creditCardNumber = creditCardNumber;
	}
	public void setCreditCardType(final String creditCardType) {
	    this.creditCardType = creditCardType;
	}

    }

    @Test
    public void testFaker() throws Exception {
	assertNoPropertyNull(PojoFaker.create().randomize(BusinessExample1.class));

    }

    @Test
    public void testFaker2() throws Exception {
	assertNoPropertyNull(PojoFaker.create().randomize(BusinessExample2.class));

    }

    @Test
    public void testFaker3() throws Exception {
	assertNoPropertyNull(PojoFaker.create().randomize(BusinessExample3.class));

    }

    @Test
    public void testFaker4() throws Exception {
	assertNoPropertyNull(PojoFaker.create().randomize(BusinessExample4.class));

    }

}
