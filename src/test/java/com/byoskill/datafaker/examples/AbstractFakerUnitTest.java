package com.byoskill.datafaker.examples;

import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractFakerUnitTest {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    protected void assertNoPropertyNull(final Object pojo) throws Exception {
	Assert.assertNotNull("Result is expected from the random function", pojo);
	final Map<String, Object> describe = BeanUtilsBean.getInstance().getPropertyUtils().describe(pojo);
	LOGGER.debug("Pojo of class {} has been generated : \n {}", pojo.getClass(), describe);
	for (final Entry<String, Object> entry : describe.entrySet()) {
	    Assert.assertNotNull("Property " + entry.getKey() + " should not be null", entry.getValue());
	}

    }
}
