/**
 * Copyright (C) 2017-2018 Credifix
 */
package com.byoskill.datafaker.exceptions;

/**
 * The Class BeanInstantiationException defines the wrapper exception when a Pojo could not be instantiated
 */
public class BeanInstantiationException extends RuntimeException {

    /**
     * Instantiates a new bean instantiation exception.
     *
     * @param e the exception
     */
    public BeanInstantiationException(final Exception e) {
	super("Bean could not be instantiated", e);
    }
}
