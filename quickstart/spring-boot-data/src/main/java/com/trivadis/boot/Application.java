package com.trivadis.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableAutoConfiguration
@EnableTransactionManagement
@EnableGlobalMethodSecurity(jsr250Enabled=true)
@ComponentScan
public class Application{
	public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}