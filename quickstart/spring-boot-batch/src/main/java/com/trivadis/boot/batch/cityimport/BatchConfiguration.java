package com.trivadis.boot.batch.cityimport;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
@EnableBatchProcessing
public class BatchConfiguration {
	public static void main(String[] args) throws Exception {
		System.exit(SpringApplication.exit(SpringApplication.run(
				BatchConfiguration.class, args)));
	}
}
