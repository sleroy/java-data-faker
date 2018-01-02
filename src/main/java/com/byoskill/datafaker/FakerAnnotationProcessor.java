/**
 * Copyright (C) 2017-2018 Credifix
 */
package com.byoskill.datafaker;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import com.byoskill.datafaker.annotations.Faker;
import com.byoskill.datafaker.configuration.FakerConfiguration;
import com.byoskill.datafaker.randomizers.Randomizer;

/**
 * The Class FakerAnnotationProcessor is scanning the bean properties to guess
 * how to randomize its data.
 */
public class FakerAnnotationProcessor {

    private final Map<BeanPropertyKey, Randomizer> cachedRand = new HashMap<>();

    private final RandomizerRegistry randomizerRegistry;

    /**
     * Instantiates a new faker annotation processor.
     *
     * @param configuration the configuration
     */
    public FakerAnnotationProcessor(final FakerConfiguration configuration) {
	super();
	randomizerRegistry = new RandomizerRegistry(configuration);
    }

    /**
     * Gets the randomizer for the given bean property.
     *
     * @param bean
     *            the bean
     * @param propertyName
     *            the property name
     * @return the randomizer
     */
    public Optional<Randomizer> getRandomizer(final Object bean, final String propertyName) {
	Validate.notNull(bean);
	Validate.notEmpty(propertyName);
	final BeanPropertyKey beanPropertyKey = BeanPropertyKey.of(bean, propertyName);
	if (cachedRand.containsKey(beanPropertyKey)) {
	    return Optional.ofNullable(cachedRand.get(beanPropertyKey));
	}
	final Optional<Randomizer> randomizer = readRandomizerProperty(bean, propertyName, beanPropertyKey);
	cachedRand.put(beanPropertyKey, randomizer.isPresent() ? randomizer.get() : null);
	return randomizer;
    }

    /**
     * Read randomizer property without access to the cache.
     *
     * @param bean
     *            the bean
     * @param propertyName
     *            the property name
     * @param beanPropertyKey
     *            the bean property key
     * @return the optional
     */
    public Optional<Randomizer> readRandomizerProperty(final Object bean, final String propertyName,
	    final BeanPropertyKey beanPropertyKey) {

	if (randomizerRegistry.hasDedicatedRandomizerForThisType(bean.getClass())) {
	    return randomizerRegistry.findTypeRandomizer(bean.getClass());
	}
	if (randomizerRegistry.isTypeAnnotated(bean.getClass())) {
	    return randomizerRegistry.findAnnotationTypeRandomizer(bean.getClass());
	}
	if (FakerBeanUtils.isPropertyAnnotatedWithFaker(beanPropertyKey)) {
	    final Optional<Faker> annotation = FakerBeanUtils.findAnnotation(BeanPropertyKey.of(bean, propertyName),
		    Faker.class);
	    final String pickedRandomizer = annotation.get().value();
	    if (StringUtils.isNotBlank(pickedRandomizer)) {
		final Optional<Randomizer> randomizerWithName = randomizerRegistry.getRandomizerWithName(pickedRandomizer);
		if (randomizerWithName.isPresent()) {
		    return Optional.of(new FieldPropertyOverridenRandomizer(propertyName, pickedRandomizer, randomizerWithName.get()));
		} else {
		    return Optional.empty();
		}
	    } else {
		return randomizerRegistry.guessRandomizerWithPropertyName(beanPropertyKey);
	    }
	} else if (randomizerRegistry.isFieldAnnotated(beanPropertyKey)) {
	    return randomizerRegistry.getFieldAnnotation(beanPropertyKey);
	} else if (FakerBeanUtils.isPojoAnnotatedWithFaker(bean)) {
	    return randomizerRegistry.guessRandomizerWithPropertyName(beanPropertyKey);
	}
	return Optional.empty();
    }

}
