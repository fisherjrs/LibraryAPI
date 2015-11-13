package com.jostens.libraryapi.context;

import org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.env.ConfigurableEnvironment;

public class LibraryAPIApplicationContext extends
		AnnotationConfigEmbeddedWebApplicationContext {

	private final AnnotatedBeanDefinitionReader reader;
	private final ClassPathBeanDefinitionScanner scanner;
	
	public LibraryAPIApplicationContext() {
		this.reader = new AnnotatedBeanDefinitionReader(this);
		this.scanner = new ClassPathBeanDefinitionScanner(this);
	}
	
	@Override
	public void setEnvironment(ConfigurableEnvironment environment) {
		super.setEnvironment(environment);
		this.reader.setEnvironment(environment);
		this.scanner.setEnvironment(environment);
	}
}
