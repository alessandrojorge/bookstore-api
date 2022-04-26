package com.alessandro.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.alessandro.bookstore.service.DBService;

@Configuration
@Profile("dev")
public class DevConfig {
	
	@Autowired
	private DBService dBService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instanciarBancoDeDados() {
		if(strategy.equals("create")) {
			this.dBService.isntanciaBaseDeDados();
		}
		return false;
	}

}

/*
 * Basicamente quando você coloca a anotação @Bean, você está dizendo para
 * Spring que quer criar esse objeto e deixar ele disponível para outras classes
 * utilizarem ele como dependência, por exemplo.
 */
