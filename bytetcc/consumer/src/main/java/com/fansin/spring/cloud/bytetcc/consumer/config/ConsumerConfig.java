package com.fansin.spring.cloud.bytetcc.consumer.config;

import org.bytesoft.bytejta.supports.jdbc.LocalXADataSource;
import org.bytesoft.bytetcc.supports.springcloud.config.SpringCloudConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

/**
 * Created with IntelliJ IDEA.
 *
 * @author fansin
 * @version 1.0
 * @date 18-2-21 下午23:51
 */
@Import(SpringCloudConfiguration.class)
@Configuration
public class ConsumerConfig {

	/**
	 * Gets data source for mybatis.
	 *
	 * @return the data source for mybatis
	 */
	@Bean(name = "dataSource")
	public DataSource getDataSource(DataSourceProperties properties) {
		LocalXADataSource dataSource = new LocalXADataSource();
		dataSource.setDataSource(properties.initializeDataSourceBuilder().build());
		return dataSource;
	}
}
