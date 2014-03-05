package com.trivadis.boot;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.context.annotation.ComponentScan;


@EnableAutoConfiguration
@ComponentScan
public class Application{
	public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}