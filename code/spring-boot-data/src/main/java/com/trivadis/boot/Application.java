package com.trivadis.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableAutoConfiguration
@EnableTransactionManagement
@ComponentScan
public class Application{
	public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}