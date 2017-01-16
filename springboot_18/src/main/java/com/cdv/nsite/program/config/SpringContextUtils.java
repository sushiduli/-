package com.cdv.nsite.program.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


@Component
public class SpringContextUtils implements ApplicationContextAware{

	private static ApplicationContext _applicationContext = null;
	
	private static MySessionListener _sessionListenser;
	
	public synchronized static int getSessionCount() {
		if (_sessionListenser == null) {
			_sessionListenser = getBean(MySessionListener.class);
		}
		if (_sessionListenser != null) {
			return _sessionListenser.getSessionCount();
		} else {
			return 0;
		}
	}
	
	public static <T> T getBean(Class<T> requiredType) {
		if (_applicationContext != null) {
			return _applicationContext.getBean(requiredType);
		} else {
			throw new org.springframework.context.ApplicationContextException("ApplicationContext has not been set.");
		}
	}

	public static <T> T getBean(String name, Class<T> requiredType) {
		if (_applicationContext != null) {
			return _applicationContext.getBean(name, requiredType);
		} else {
			throw new org.springframework.context.ApplicationContextException("ApplicationContext has not been set.");
		}
	}

	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		_applicationContext = applicationContext;
	}

}
