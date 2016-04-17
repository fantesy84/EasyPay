package net.fantesy84.util;

import java.util.Map;

public interface ParameterBeanHandler {
	Map<String, ?> retrievePropertiesMap(Object bean) throws Throwable;
}
