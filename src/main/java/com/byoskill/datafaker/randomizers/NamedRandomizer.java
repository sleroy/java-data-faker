/**
 * Copyright (C) 2017-2018 Credifix
 */
package com.byoskill.datafaker.randomizers;

public interface NamedRandomizer extends Randomizer {

    /**
     * Gets the supported names.
     *
     * @return the supported names
     */
    public String[] getSupportedNames();
}
