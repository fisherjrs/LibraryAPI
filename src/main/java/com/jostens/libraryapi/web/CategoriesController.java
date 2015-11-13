package com.jostens.libraryapi.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/libraryservices/categories/v1")
public class CategoriesController {

	private static Logger LOG = LoggerFactory.getLogger(CategoriesController.class);
	
	@RequestMapping(value="/getimagecategorytree", method={RequestMethod.GET})
	public String getImageCategoryTree() {
		LOG.info("it's true.");
		return "hola";
	}
}
