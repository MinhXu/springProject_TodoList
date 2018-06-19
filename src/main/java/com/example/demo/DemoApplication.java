package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Configuration
@EnableAutoConfiguration
@EntityScan("model")
@ComponentScan ({"demo","controller","com.example.dao","repository"})
//@EnableJpaRepositories(basePackages = {"repository"})
@SpringBootApplication(scanBasePackages= {"com.example.dao"})
public class DemoApplication {
//	
//	@ResponseBody
//	@RequestMapping("/")
//	String entry()
//	{
//		return "Minh Ngo Ngoc";
	
//	}
	
	

	public static void main(String[] args) {
		
		
		SpringApplication.run(DemoApplication.class, args);
	}
}
