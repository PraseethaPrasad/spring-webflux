package com.sample.webflux.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import com.sample.webflux.repository.EmployeeRepository;

@Configuration
@EnableReactiveMongoRepositories(basePackageClasses = EmployeeRepository.class)
@PropertySource("classpath:application.properties")
public class AppConfig extends AbstractReactiveMongoConfiguration {

	@Value("${spring.data.mongodb.database}")
	private String database;

	@Value("${spring.data.mongodb.port}")
	private Integer port;

	@Value("${spring.data.mongodb.host}")
	private String host;

	@Override
	@Bean
	public MongoClient reactiveMongoClient() {

		return MongoClients.create("mongodb://localhost:27017/webfluxdb");

	}

	@Override
	protected String getDatabaseName() {
		return database;
	}
	
	protected String getMappingBasePackage() {
		return "com.sample.webflux.entity";
	}

	@Bean
	public ReactiveMongoTemplate reactiveMongoTemplate() {
		return new ReactiveMongoTemplate(reactiveMongoClient(), getDatabaseName());
	}
}