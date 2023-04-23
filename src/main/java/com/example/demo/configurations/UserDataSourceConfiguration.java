package com.example.demo.configurations;

import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import com.example.demo.entities.UserEntity;

/**
 * @author YoussefMahmoud
 * @created Apr 22, 2023-3:47:49 AM
 */

@Configuration
@EnableJpaRepositories(basePackages = "com.example.demo.repositories.user", entityManagerFactoryRef = "userEntityManagerFactory", transactionManagerRef = "userTransactionManager")
public class UserDataSourceConfiguration {

	@Bean
	@ConfigurationProperties("app.datasource.user")
	public DataSourceProperties userDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	@ConfigurationProperties("app.datasource.user.configuration")
	public DataSource userDataSource() {
		return userDataSourceProperties().initializeDataSourceBuilder().type(BasicDataSource.class).build();
	}

	@Bean(name = "userEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean userEntityManagerFactory(EntityManagerFactoryBuilder builder) {
		return builder.dataSource(userDataSource()).packages(UserEntity.class).build();
	}

	@Bean
	public PlatformTransactionManager userTransactionManager(
			final @Qualifier("userEntityManagerFactory") LocalContainerEntityManagerFactoryBean userEntityManagerFactory) {
		return new JpaTransactionManager(userEntityManagerFactory.getObject());
	}

}