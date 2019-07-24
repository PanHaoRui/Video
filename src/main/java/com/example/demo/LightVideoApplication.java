package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication /*
						 * (exclude = { DataSourceAutoConfiguration.class,
						 * HibernateJpaAutoConfiguration.class })
						 */
public class LightVideoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(LightVideoApplication.class, args);
	}

}
