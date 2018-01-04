package com.byoskill.datafaker;

import com.byoskill.datafaker.randomizers.Randomizer;

public class FieldPropertyOverridenRandomizer implements Randomizer {

    private final String oldPropertyName;
    private final String overridenProperty;
    private final Randomizer randomizer;

    public FieldPropertyOverridenRandomizer(final String propertyName, final String overridenProperty, final Randomizer randomizer) {
	oldPropertyName = propertyName;
	this.overridenProperty = overridenProperty;
	this.randomizer = randomizer;

    }

    @Override
    public Object getRandomValue(final Object bean, final String propertyName) {
	if (propertyName.equals(oldPropertyName)) {
	    return randomizer.getRandomValue(bean, overridenProperty);
	}
	return randomizer.getRandomValue(bean, propertyName);
    }

}
