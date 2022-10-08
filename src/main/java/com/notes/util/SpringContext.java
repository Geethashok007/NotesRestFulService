package com.notes.util;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContext implements ApplicationContextAware {

	private ApplicationContext appContext;
	
	private static ApplicationContext context;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.appContext = applicationContext;
	}

	@PostConstruct
	public void setContext() {
		context = appContext;
	}
	
	public static <T> T getBean(String beanName, Class<T> className) {
		return context.getBean(beanName, className);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanName) {
		return (T) context.getBean(beanName);
	}
	
	public static <T> T getBean(Class<T> className) {
		return context.getBean(className);
	}
}

