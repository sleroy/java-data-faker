/**
 * Copyright (C) 2017-2018 Credifix
 */
package com.byoskill.datafaker;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.beanutils.BeanUtilsBean;

import com.byoskill.datafaker.configuration.DefaultFakerConfiguration;
import com.byoskill.datafaker.configuration.FakerConfiguration;
import com.byoskill.datafaker.exceptions.BeanInstantiationException;
import com.byoskill.datafaker.exceptions.IllegalBeanAccessException;
import com.byoskill.datafaker.exceptions.UninstantiableBeanException;
import com.byoskill.datafaker.randomizers.Randomizer;

public class PojoFaker {

    /**
     * Creates the utility class.
     *
     * @param configuration
     *
     * @return the pojo faker
     */
    public static PojoFaker create() {
	return new PojoFaker(new DefaultFakerConfiguration());
    }

    /**
     * Creates the utility class.
     *
     * @param configuration
     *
     * @return the pojo faker
     */
    public static PojoFaker create(final FakerConfiguration configuration) {
	return new PojoFaker(configuration);
    }

    private final FakerAnnotationProcessor fakerAnnotationProcessor;

    private PojoFaker(final FakerConfiguration configuration) {
	super();
	fakerAnnotationProcessor = new FakerAnnotationProcessor(configuration);
    }

    /**
     * Instantiate the object and randomize its data.
     *
     * @param <T>
     *            the generic type of the implementation
     * @param _implementationClass
     *            the implementation class
     * @return a randomized new instance
     */
    public <T> T randomize(final Class<T> _implementationClass) throws RuntimeException {

	T bean;
	try {
	    bean = FakerBeanUtils.instantiateBean(_implementationClass);
	} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException
		| UninstantiableBeanException e) {
	    throw new BeanInstantiationException(e);
	}
	return randomize(bean);
    }

    /**
     * Randomize the provided object instance.
     *
     * @param <T>
     *            the generic type
     * @param bean
     *            the object instance
     * @return the same object instance to perform chaining if necessary.
     */
    public <T> T randomize(final T bean) {
	try {
	    final Map<String, Object> propertyDescription = BeanUtilsBean.getInstance().getPropertyUtils()
		    .describe(bean);
	    for (final String propertyKey : propertyDescription.keySet()) {
		randomProperty(bean, propertyKey);
	    }
	} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
	    throw new IllegalBeanAccessException("Could not access to the bean properties", e);
	}
	return bean;
    }

    /**
     * Randomize for the provided object instance, the given property
     *
     * @param <T>
     *            the generic type
     * @param bean
     *            the object instance
     * @param propertyName
     *            the property name
     * @return the same object instance to perform chaining if necessary.
     */
    public <T> T randomProperty(final T bean, final String propertyName) {

	if (FakerBeanUtils.isPropertyAccessible(bean, propertyName)) {
	    final Optional<Randomizer> randomizer = fakerAnnotationProcessor.getRandomizer(bean, propertyName);
	    if (randomizer.isPresent()) {

		final Object randomValue = randomizer.get().getRandomValue(bean, propertyName);
		if (randomValue != null) {
		    FakerBeanUtils.setProperty(bean, propertyName, randomValue);
		} else {
		    // We skip null values
		}

	    }
	}
	return bean;
    }

}
