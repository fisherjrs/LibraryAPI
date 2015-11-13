package com.jostens.libraryapi;

import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.jostens.libraryapi.config.LibraryAPIConfig;
import com.jostens.libraryapi.context.LibraryAPIApplicationContext;

@ComponentScan
@Configuration
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class LibraryAPIApplication {

	private static Logger LOG = LoggerFactory.getLogger(LibraryAPIApplication.class);
	
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(LibraryAPIApplication.class);
		
        application.setSources(defineConfigSources());
        
        //application.addListeners(new ListenerApplication());
        
        application.setApplicationContextClass(LibraryAPIApplicationContext.class);    
               
        //Enable/Disable container restart when saving files.
    	//System.setProperty("spring.devtools.restart.enabled", "false");
    	
    	ApplicationContext applicationContext = application.run(args);
    	LOG.info("application context :: {}",  applicationContext.getClass());	
		
	}
	
	private static HashSet<Object> defineConfigSources() {
		HashSet<Object> sources = new HashSet<Object>();
		sources.add(LibraryAPIConfig.class);
		return sources;
	}
}
