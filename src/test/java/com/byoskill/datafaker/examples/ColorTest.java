package com.byoskill.datafaker.examples;

import org.junit.Test;

import com.byoskill.datafaker.PojoFaker;
import com.byoskill.datafaker.annotations.Color;
import com.byoskill.datafaker.annotations.Faker;

public class ColorTest extends AbstractFakerUnitTest {

    @Faker
    public static class ColorExample1 {

	private String colorName;

	public String getColorName() {
	    return colorName;
	}

	public void setColorName(final String colorName) {
	    this.colorName = colorName;
	}
    }

    public static class ColorExample2 {

	@Faker
	private String colorName;

	@Faker("colorName")
	private String name;

	public String getColorName() {
	    return colorName;
	}

	public String getName() {
	    return name;
	}

	public void setColorName(final String colorName) {
	    this.colorName = colorName;
	}

	public void setName(final String name) {
	    this.name = name;
	}
    }

    public static class ColorExample3 {


	@Color
	private String name;

	public String getName() {
	    return name;
	}


	public void setName(final String name) {
	    this.name = name;
	}
    }

    @Color
    public static class ColorExample4 {

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
	assertNoPropertyNull(PojoFaker.create().randomize(ColorExample1.class));

    }

    @Test
    public void testFaker2() throws Exception {
	assertNoPropertyNull(PojoFaker.create().randomize(ColorExample2.class));

    }

    @Test
    public void testFaker3() throws Exception {
	assertNoPropertyNull(PojoFaker.create().randomize(ColorExample3.class));

    }

    @Test
    public void testFaker4() throws Exception {
	assertNoPropertyNull(PojoFaker.create().randomize(ColorExample4.class));

    }

}
