package com.example.demo.configurations;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author YoussefMahmoud
 * @created Apr 22, 2023-3:47:49 AM
 */

@Configuration
public class ChainedTransactionManagerConfig {

	@Bean(name = "chainedTransactionManager")
	public ChainedTransactionManager createChainedTransactionManager(
			@Qualifier("departmentTransactionManager") PlatformTransactionManager departmentTransactionManager,
			@Qualifier("userTransactionManager") PlatformTransactionManager userTransactionManager) {
		return new ChainedTransactionManager(departmentTransactionManager, userTransactionManager);
	}

}