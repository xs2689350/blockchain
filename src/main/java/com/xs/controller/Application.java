package com.xs.controller;




import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@MapperScan("com.xs.mapper")
@ComponentScan(basePackages="com.xs.controller")
@ComponentScan("com.xs.service")
@ComponentScan("com.xs.chain")
@ServletComponentScan("com.xs.filter")
public class Application {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	     SpringApplication.run(Application.class, args); 
	}

}
