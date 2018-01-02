/**
 * Copyright (C) 2017-2018 Credifix
 */
package com.byoskill.datafaker.randomizers;

@FunctionalInterface
public interface Randomizer {

    /**
     * Returns a random value for the given bean and property
     *
     * @param bean the bean
     * @param propertyName the property name
     * @return the instance or a cloned one depending of the randomizer implementation
     */
    public Object getRandomValue(Object bean, String propertyName);
}
