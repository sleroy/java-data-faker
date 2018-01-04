package com.byoskill.datafaker.examples;

import org.junit.Test;

import com.byoskill.datafaker.PojoFaker;
import com.byoskill.datafaker.annotations.Company;
import com.byoskill.datafaker.annotations.Faker;

public class CompanyTest extends AbstractFakerUnitTest {

    @Faker
    public static class CompanyExample1 {

	private String companyName;

	public String getCompanyName() {
	    return companyName;
	}

	public void setCompanyName(final String companyName) {
	    this.companyName = companyName;
	}

    }

    public static class CompanyExample2 {

	@Faker
	private String companyName;

	public String getCompanyName() {
	    return companyName;
	}

	public void setCompanyName(final String companyName) {
	    this.companyName = companyName;
	}


    }

    public static class CompanyExample3  {


	@Company
	private String name;

	public String getName() {
	    return name;
	}


	public void setName(final String name) {
	    this.name = name;
	}
    }

    @Company
    public static class CompanyExample4 {

	private String name;

	public String getName() {
	    return name;
	}

	public void setName(final String name) {
	    this.name = name;
	}
    }

    @Test
    public void testFaker() throws Exception {
	assertNoPropertyNull(PojoFaker.create().randomize(CompanyExample1.class));

    }

    @Test
    public void testFaker2() throws Exception {
	assertNoPropertyNull(PojoFaker.create().randomize(CompanyExample2.class));

    }

    @Test
    public void testFaker3() throws Exception {
	assertNoPropertyNull(PojoFaker.create().randomize(CompanyExample3.class));

    }

    @Test
    public void testFaker4() throws Exception {
	assertNoPropertyNull(PojoFaker.create().randomize(CompanyExample4.class));

    }

}
