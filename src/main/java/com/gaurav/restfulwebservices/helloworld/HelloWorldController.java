package com.gaurav.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;

	@GetMapping
	public String helloWorld() {
		return "hello world";
	}
	
	@GetMapping("/path-variable/{name}")
	public String pathVariable(@PathVariable String name) {
		return String.format("Hello World, %s", name);
	}
	
	@GetMapping("/hello-world-i18n")
	public String helloWorldI18N() {
		return messageSource.getMessage("hello.world.msg", null,"Default message", LocaleContextHolder.getLocale());
	}
}
