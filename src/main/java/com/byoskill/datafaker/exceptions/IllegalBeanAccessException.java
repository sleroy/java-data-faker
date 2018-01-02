/**
 * Copyright (C) 2017-2018 Credifix
 */
package com.byoskill.datafaker.exceptions;


/**
 * The Class IllegalBeanAccessException when bean properties could not be accessed.
 */
public class IllegalBeanAccessException extends RuntimeException {

    /**
     * Instantiates a new illegal bean access exception.
     */
    public IllegalBeanAccessException() {

    }

    /**
     * Instantiates a new illegal bean access exception.
     *
     * @param message the message
     */
    public IllegalBeanAccessException(final String message) {
	super(message);

    }

    /**
     * Instantiates a new illegal bean access exception.
     *
     * @param message the message
     * @param cause the cause
     */
    public IllegalBeanAccessException(final String message, final Throwable cause) {
	super(message, cause);

    }

    /**
     * Instantiates a new illegal bean access exception.
     *
     * @param message the message
     * @param cause the cause
     * @param enableSuppression the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public IllegalBeanAccessException(final String message, final Throwable cause, final boolean enableSuppression,
	    final boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);

    }

    /**
     * Instantiates a new illegal bean access exception.
     *
     * @param cause the cause
     */
    public IllegalBeanAccessException(final Throwable cause) {
	super(cause);

    }
}
