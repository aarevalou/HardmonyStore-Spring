package com.ufro.harmonystore;

import com.ufro.harmonystore.config.DatabaseConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

@SpringBootApplication
@Import(DatabaseConfig.class)
public class HarmonyStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(HarmonyStoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(DataSource dataSource, ResourceDatabasePopulator databasePopulator) {
		return args -> databasePopulator.populate(dataSource.getConnection());
	}

}
