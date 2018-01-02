/**
 * Copyright (C) 2017-2018 Credifix
 */
package com.byoskill.datafaker;

import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.reflect.ConstructorUtils;

import com.byoskill.datafaker.annotations.Faker;
import com.byoskill.datafaker.exceptions.IllegalBeanAccessException;
import com.byoskill.datafaker.exceptions.UninstantiableBeanException;

/**
 * The Class FakerBeanUtils provides convenient method to access bean
 * properties.
 */
public class FakerBeanUtils {

    /**
     * Gets the request annotation if possible-.
     *
     * @param <T>
     *            the generic type
     * @param beanPropertyKey
     *            the bean property key
     * @param requestAnnotation
     *            the request annotation
     * @return the faker annotation
     */
    public static <T extends Annotation> Optional<T> findAnnotation(final BeanPropertyKey beanPropertyKey,
	    final Class<T> requestAnnotation) {

	Field declaredField = null;
	Class<?> thisClass = beanPropertyKey.getClazz();
	while (thisClass != null && declaredField == null) {
	    try {
		declaredField = beanPropertyKey.getClazz().getDeclaredField(beanPropertyKey.getProperty());
	    } catch (NoSuchFieldException | SecurityException e) {
		e.printStackTrace();
	    }
	    thisClass = thisClass.getSuperclass();
	}

	if (declaredField == null) {
	    return Optional.empty();
	}
	if (declaredField.isAnnotationPresent(requestAnnotation)) {
	    return Optional.ofNullable(declaredField.getAnnotation(requestAnnotation));
	}
	final Optional<PropertyDescriptor> propertyDescriptor = getPropertyDescriptor(beanPropertyKey);
	if (!propertyDescriptor.isPresent()) {
	    return Optional.empty();
	}
	final Method readMethod = BeanUtilsBean.getInstance().getPropertyUtils()
		.getReadMethod(propertyDescriptor.get());

	if (readMethod != null) {
	    return Optional.ofNullable(readMethod.getAnnotation(requestAnnotation));
	}
	return Optional.empty();
    }

    /**
     * Instantiate bean.
     *
     * @param <T>
     *            the generic type
     * @param _implementationClass
     *            the implementation class
     * @return the t
     * @throws UninstantiableBeanException
     *             the uninstantiable bean exception
     * @throws NoSuchMethodException
     *             the no such method exception
     * @throws IllegalAccessException
     *             the illegal access exception
     * @throws InvocationTargetException
     *             the invocation target exception
     * @throws InstantiationException
     *             the instantiation exception
     */
    public static <T> T instantiateBean(final Class<T> _implementationClass) throws UninstantiableBeanException,
    NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
	final Constructor<T> accessibleConstructor = ConstructorUtils.getAccessibleConstructor(_implementationClass);
	if (accessibleConstructor == null) {
	    throw new UninstantiableBeanException();
	}
	return ConstructorUtils.invokeConstructor(_implementationClass);
    }

    /**
     * Checks if is pojo annotated with faker annotation.
     *
     * @param bean
     *            the bean
     * @return true, if is pojo annotated with faker
     */
    public static boolean isPojoAnnotatedWithFaker(final Object bean) {
	Validate.notNull(bean);
	return bean.getClass().isAnnotationPresent(Faker.class);
    }

    /**
     * Checks if is property accessible.
     *
     * @param bean
     *            the bean
     * @param propertyName
     *            the property name
     * @return true, if is property accessible
     */
    public static boolean isPropertyAccessible(final Object bean, final String propertyName) {

	return PropertyUtils.isReadable(bean, propertyName) && PropertyUtils.isWriteable(bean, propertyName);
    }

    /**
     * Checks if is property annotated with faker.
     *
     * @param beanPropertyKey
     *            the bean property key
     * @return true, if is property annotated with faker
     */
    public static boolean isPropertyAnnotatedWithFaker(final BeanPropertyKey beanPropertyKey) {

	return findAnnotation(beanPropertyKey, Faker.class).isPresent();

    }

    /**
     * Sets the property.
     *
     * @param bean
     *            the bean
     * @param propertyName
     *            the property name
     * @param randomValue
     *            the random value
     * @return the object
     */
    public static Object setProperty(final Object bean, final String propertyName, final Object randomValue) {
	try {
	    BeanUtilsBean.getInstance().getPropertyUtils().setProperty(bean, propertyName, randomValue);
	} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
	    throw new IllegalBeanAccessException("Could not assign the value", e);
	}
	return bean;
    }

    /**
     * Gets the property descriptor.
     *
     * @param beanPropertyKey
     *            the bean property key
     * @return the property descriptor
     */
    private static Optional<PropertyDescriptor> getPropertyDescriptor(final BeanPropertyKey beanPropertyKey) {
	final PropertyDescriptor[] propertyDescriptors = BeanUtilsBean.getInstance().getPropertyUtils()
		.getPropertyDescriptors(beanPropertyKey.getClazz());
	final Optional<PropertyDescriptor> findFirst = Arrays.stream(propertyDescriptors)
		.filter(pd -> beanPropertyKey.hasSamePropertyName(pd.getName())).findFirst();
	return findFirst;
    }
}
