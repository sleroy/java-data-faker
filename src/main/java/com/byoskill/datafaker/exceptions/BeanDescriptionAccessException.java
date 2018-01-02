/**
 * Copyright (C) 2017-2018 Credifix
 */
package com.byoskill.datafaker.exceptions;


/**
 * The Class BeanDescriptionAccessException is thrown when the properties could not be aaccessed
 */
public class BeanDescriptionAccessException extends RuntimeException {

    /**
     * Instantiates a new bean description access exception.
     */
    public BeanDescriptionAccessException() {
	super();
    }

    /**
     * Instantiates a new bean description access exception.
     *
     * @param message the message
     */
    public BeanDescriptionAccessException(final String message) {
	super(message);

    }

    /**
     * Instantiates a new bean description access exception.
     *
     * @param message the message
     * @param cause the cause
     */
    public BeanDescriptionAccessException(final String message, final Throwable cause) {
	super(message, cause);

    }

    /**
     * Instantiates a new bean description access exception.
     *
     * @param message the message
     * @param cause the cause
     * @param enableSuppression the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public BeanDescriptionAccessException(final String message, final Throwable cause, final boolean enableSuppression,
	    final boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);

    }

    /**
     * Instantiates a new bean description access exception.
     *
     * @param cause the cause
     */
    public BeanDescriptionAccessException(final Throwable cause) {
	super(cause);

    }
}
