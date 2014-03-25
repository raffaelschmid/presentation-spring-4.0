package com.trivadis.cities;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//tells spring boot to use @RolesAllowed, etc.
@EnableGlobalMethodSecurity(jsr250Enabled = true)
// enables springs annotation driven transaction management
@EnableTransactionManagement
// enables component scan from the current package
@ComponentScan
// enable auto-configuration based on classpath settings, beans, etc.
@EnableAutoConfiguration
public class Application {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
}
