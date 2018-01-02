/**
 * Copyright (C) 2017-2018 Credifix
 */
package com.byoskill.datafaker.exceptions;

import java.text.MessageFormat;

public class OverridedRandomizerException extends RuntimeException {


    /**
     * Instantiates a new overrided randomizer exception.
     *
     * @param pattern the pattern
     * @param annotationClass the annotation class
     */
    public OverridedRandomizerException(final String pattern, final Object...args) {
	super(MessageFormat.format(pattern, args));
    }
}
