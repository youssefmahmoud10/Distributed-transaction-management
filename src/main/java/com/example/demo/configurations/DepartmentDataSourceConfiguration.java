package com.example.demo.configurations;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.example.demo.entities.DepartmentEntity;
import com.zaxxer.hikari.HikariDataSource;

/**
 * @author YoussefMahmoud
 * @created Apr 23, 2023-3:02:42 AM
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.example.demo.repositories.department", entityManagerFactoryRef = "departmentEntityManagerFactory", transactionManagerRef = "departmentTransactionManager")
public class DepartmentDataSourceConfiguration {

	@Bean
	@Primary
	@ConfigurationProperties("app.datasource.department")
	public DataSourceProperties departmentDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	@Primary
	@ConfigurationProperties("app.datasource.department.configuration")
	public DataSource departmentDataSource() {
		return departmentDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}

	@Primary
	@Bean(name = "departmentEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean departmentEntityManagerFactory(EntityManagerFactoryBuilder builder) {
		return builder.dataSource(departmentDataSource()).packages(DepartmentEntity.class).build();
	}

	@Primary
	@Bean
	public PlatformTransactionManager departmentTransactionManager(
			final @Qualifier("departmentEntityManagerFactory") LocalContainerEntityManagerFactoryBean departmentEntityManagerFactory) {
		return new JpaTransactionManager(departmentEntityManagerFactory.getObject());
	}

}