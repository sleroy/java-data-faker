/**
 * Copyright (C) 2017-2018 Credifix
 */
package com.byoskill.datafaker;

import org.apache.commons.lang3.Validate;

public class BeanPropertyKey {

    /**
     * Instantiates a new property bean key-
     *
     * @param bean
     *            the bean
     * @param propertyName
     *            the property name
     * @return the bean property key
     */
    public static BeanPropertyKey of(final Object bean, final String propertyName) {
	Validate.notNull(bean);
	Validate.notEmpty(propertyName);
	return new BeanPropertyKey(bean.getClass(), propertyName);

    }

    private final Class<?> clazz;

    private final String property;

    /**
     * Instantiates a new bean property key.
     *
     * @param clazz
     *            the clazz
     * @param property
     *            the property
     */
    public BeanPropertyKey(final Class<?> clazz, final String property) {
	super();
	this.clazz = clazz;
	this.property = property;
    }

    @Override
    public boolean equals(final Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	final BeanPropertyKey other = (BeanPropertyKey) obj;
	if (clazz == null) {
	    if (other.clazz != null) {
		return false;
	    }
	} else if (!clazz.equals(other.clazz)) {
	    return false;
	}
	if (property == null) {
	    if (other.property != null) {
		return false;
	    }
	} else if (!property.equals(other.property)) {
	    return false;
	}
	return true;
    }

    /**
     * Gets the clazz.
     *
     * @return the clazz
     */
    public Class<?> getClazz() {
	return clazz;
    }

    /**
     * Gets the property.
     *
     * @return the property
     */
    public String getProperty() {
	return property;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (clazz == null ? 0 : clazz.hashCode());
	result = prime * result + (property == null ? 0 : property.hashCode());
	return result;
    }

    /**
     * Checks for same property name.
     *
     * @param propertyName the property name
     * @return true, if successful
     */
    public boolean hasSamePropertyName(final String propertyName) {

	return property.equals(propertyName);
    }

    @Override
    public String toString() {
	return "BeanPropertyKey [clazz=" + clazz + ", property=" + property + "]";
    }
}
