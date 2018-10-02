package com.eric.spoot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Value("${hello.default.name}")
	private String defaultName;
	
	@GetMapping("/hello/{name}")
	public String hello(@PathVariable("name") String name) {
		return "Hello! "+name+", this is docker world.";
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello! "+defaultName+", this is docker world.";
	}
}
