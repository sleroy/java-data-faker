/**
 * Copyright (C) 2017-2018 Credifix
 */
package com.byoskill.datafaker;

import java.lang.annotation.Annotation;
import java.util.Optional;

import com.byoskill.datafaker.configuration.FakerConfiguration;
import com.byoskill.datafaker.configuration.IRandomizerMappingDeclarations;
import com.byoskill.datafaker.mappings.BeanPropertyRandomizerMappings;
import com.byoskill.datafaker.mappings.FieldAnnotationMappings;
import com.byoskill.datafaker.mappings.NamedRandomizerMapping;
import com.byoskill.datafaker.mappings.TypeAnnotationMappings;
import com.byoskill.datafaker.mappings.TypeRandomizerMappings;
import com.byoskill.datafaker.randomizers.BeanPropertyRandomizer;
import com.byoskill.datafaker.randomizers.FieldAnnotationRandomizer;
import com.byoskill.datafaker.randomizers.NamedRandomizer;
import com.byoskill.datafaker.randomizers.Randomizer;
import com.byoskill.datafaker.randomizers.TypeAnnotationRandomizer;

/**
 * The Class RandomizerRegistry is performing the mapping between property names
 * and their corresponding randomizer.
 */
public class RandomizerRegistry {

    /** The bean property randomizer mapping. */
    private final BeanPropertyRandomizerMappings beanPropertyRandomizerMapping = new BeanPropertyRandomizerMappings();

    private final FieldAnnotationMappings fieldAnnotationMappings = new FieldAnnotationMappings();

    private final NamedRandomizerMapping namedRandomizerMapping = new NamedRandomizerMapping();

    private final TypeAnnotationMappings typeAnnotationMappings = new TypeAnnotationMappings();

    private final TypeRandomizerMappings typeRandomizerMapping = new TypeRandomizerMappings();

    /**
     * Instantiates a new randomizer registry.
     *
     * @param configuration
     *            the configuration
     */
    public RandomizerRegistry(final FakerConfiguration configuration) {
	configuration.init(new IRandomizerMappingDeclarations() {


	    /**
	     * Declares annotation randomizer.
	     *
	     * @param <A> the generic type of the annotatoin
	     * @param <T> the generic type of the implementation
	     * @param annotationclass the annotationclass
	     * @param randomizer the randomizer
	     */
	    @Override
	    public <A extends Annotation, T extends NamedRandomizer & FieldAnnotationRandomizer<A> & TypeAnnotationRandomizer<A> > void declaresAnnotationRandomizer(final Class<A> annotationclass, final T randomizer) {
		declaresFieldAnnotationRandomizer(annotationclass, randomizer);
		declaresTypeAnnotationRandomizer(annotationclass, randomizer);
		declaresNamedRandomizer(randomizer);
	    }

	    @Override
	    public void declaresBeanPropertyRandomizer(final BeanPropertyKey beanPropertyKey,
		    final BeanPropertyRandomizer randomizer) {
		beanPropertyRandomizerMapping.declare(beanPropertyKey, randomizer);

	    }

	    @Override
	    public <A extends Annotation> void declaresFieldAnnotationRandomizer(final Class<A> annotationClass,
		    final FieldAnnotationRandomizer<A> randomizer) {
		fieldAnnotationMappings.declare(annotationClass, randomizer);

	    }

	    @Override
	    public void declaresNamedRandomizer(final NamedRandomizer randomizer) {
		for (final String supportedName : randomizer.getSupportedNames()) {
		    namedRandomizerMapping.declare(supportedName, randomizer);
		}

	    }

	    @Override
	    public void declaresNamedRandomizer(final String name, final Randomizer randomizer) {
		namedRandomizerMapping.declare(name, randomizer);
	    }

	    @Override
	    public <A extends Annotation> void declaresTypeAnnotationRandomizer(final Class<A> annotationClass,
		    final TypeAnnotationRandomizer<A> annotationRandomizer) {
		typeAnnotationMappings.declare(annotationClass, annotationRandomizer);

	    } @Override
	    public void declaresTypeRandomizer(final Class<?> implementation, final Randomizer randomizer) {
		typeRandomizerMapping.declare(implementation, randomizer);

	    }


	});

    }

    /**
     * Find annotation type randomizer.
     *
     * @param implementationClass the class
     * @return the randomizer or null
     */
    public Optional<Randomizer> findAnnotationTypeRandomizer(final Class<? extends Object> implementationClass) {

	return typeAnnotationMappings.findSupportedRandomizer(implementationClass);
    }

    /**
     * Find a randomizer dedicated to a type.
     *
     * @param class1 the class 1
     * @return the result
     */
    public Optional<Randomizer> findTypeRandomizer(final Class<?> class1) {

	return typeRandomizerMapping.findSupportedRandomizer(class1);
    }

    /**
     * Gets the randomizer from a specific Faker annotation. If the annotation
     * is missing on the property , there is no fallback and it returns empty.
     *
     * @param beanPropertyKey
     *            the bean property key
     * @return the randomizer from annotation
     */
    public Optional<Randomizer> getFieldAnnotation(final BeanPropertyKey beanPropertyKey) {
	if (hasDedicatedRandomizerForThisType(beanPropertyKey.getClazz())) {
	    return findTypeRandomizer(beanPropertyKey.getClazz());
	}
	return fieldAnnotationMappings.findSupportedRandomizer(beanPropertyKey);

    }

    /**
     * Gets the randomizer with its name.
     *
     * @param pickedRandomizer
     *            the picked randomizer
     * @return the randomizer with name
     */
    public Optional<Randomizer> getRandomizerWithName(final String pickedRandomizer) {

	return namedRandomizerMapping.findRandomizerWithName(pickedRandomizer);
    }

    /**
     * Guess randomizer with a property name.
     *
     * @param beanPropertyKey
     *            the bean property key
     * @return the optional
     */
    public Optional<Randomizer> guessRandomizerWithPropertyName(final BeanPropertyKey beanPropertyKey) {
	if (hasDedicatedRandomizerForThisType(beanPropertyKey.getClazz())) {
	    return findTypeRandomizer(beanPropertyKey.getClazz());
	}
	if (beanPropertyRandomizerMapping.isSupportedMapping(beanPropertyKey)) {
	    return beanPropertyRandomizerMapping.findSupportedRandomizer(beanPropertyKey);
	}
	return getRandomizerWithName(beanPropertyKey.getProperty());
    }

    /**
     * Checks for dedicated randomizer for this type.
     *
     * @param implementation the implementation
     * @return true, if successful
     */
    public boolean hasDedicatedRandomizerForThisType(final Class<?> implementation) {

	return typeRandomizerMapping.isSupportedWith(implementation);
    }

    /**
     * Checks if is property annotated with domain faker annotation.
     *
     * @param beanPropertyKey
     *            the bean property key
     * @return true, if is property annotated with domain faker annotation
     */
    public boolean isFieldAnnotated(final BeanPropertyKey beanPropertyKey) {

	return fieldAnnotationMappings.findSupportedRandomizer(beanPropertyKey).isPresent();
    }

    /**
     * Checks if is type annotated.
     *
     * @param class1 the implementation class
     * @return true, if is type annotated
     */
    public boolean isTypeAnnotated(final Class<? extends Object> class1) {

	return typeAnnotationMappings.isSupportedBy(class1);
    }

}
