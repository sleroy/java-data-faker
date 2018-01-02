/**
 * Copyright (C) 2017-2018 Credifix
 */
package com.byoskill.datafaker.randomizers;

import com.byoskill.datafaker.BeanPropertyKey;

@FunctionalInterface
public interface BeanPropertyRandomizer {

    /**
     * Returns a random value for the given bean and property.
     *
     * @param beanPropertyKey the bean property key
     * @return the random value for the given bean property
     */
    public Object getRandomValue(BeanPropertyKey beanPropertyKey);
}
