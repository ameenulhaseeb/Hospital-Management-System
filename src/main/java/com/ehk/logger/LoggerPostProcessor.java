package com.ehk.logger;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.ReflectionUtils.FieldCallback;

import com.ehk.util.HMSLogger;

@Component
public class LoggerPostProcessor implements BeanPostProcessor {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) {
		return bean;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object postProcessBeforeInitialization(final Object bean, String beanName) {
		ReflectionUtils.doWithFields(bean.getClass(), new FieldCallback() {
			@Override
			public void doWith(Field field) throws IllegalAccessException {
				if (field.getAnnotation(HMSLogger.class) != null) {
					Logger log = LoggerFactory.getLogger(bean.getClass());
					ReflectionUtils.makeAccessible(field);
					field.set(bean, log);
				}
			}
		});
		return bean;
	}

}	
