package com.rest.restservice;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan("com.notes")
@EnableJpaRepositories("com.notes.repo")
@EntityScan("com.notes.model")
public class NotesConfig {

	@Bean("h2Props")
	@ConfigurationProperties("spring.datasource")
	public HikariConfig h2Props() {
		return new HikariConfig();
	}
	
	@Bean("h2DataSource")
	public DataSource h2DataSource(@Qualifier("h2Props") HikariConfig config) {
		return new HikariDataSource(config);
	}
}

