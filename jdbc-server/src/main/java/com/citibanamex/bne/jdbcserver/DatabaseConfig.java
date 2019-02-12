package com.citibanamex.bne.jdbcserver;

 
import java.beans.PropertyVetoException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
public class DatabaseConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(DatabaseConfig.class);

	private static final String PROPERTY_NAME_DATABASE_DRIVER = "db.driverClass";
	private static final String PROPERTY_NAME_DATABASE_URL = "db.jdbcUrl";
	private static final String PROPERTY_NAME_DATASOURCE_MINPOOLSIZE = "c3p0.minPoolSize";
	private static final String PROPERTY_NAME_DATASOURCE_MAXPOOLSIZE = "c3p0.maxPoolSize";
	private static final String PROPERTY_NAME_DATASOURCE_ACQUIREINCREMENT = "c3p0.acquireIncrement";
	private static final String PROPERTY_NAME_DATASOURCE_BREAKAFTERACQUIREFAILURE = "c3p0.breakAfterAcquireFailure";
	private static final String PROPERTY_NAME_DATASOURCE_MAXIDLETIME = "c3p0.maxIdleTime";
	
	private static final String PROPERTY_NAME_EF_DATABASE_USERNAME = "db.ef.user";
	private static final String PROPERTY_NAME_EF_DATABASE_PASSWORD = "db.ef.password";
	
	@Resource
	private Environment env;
	
	@Bean(name = "dataSource")
	public DataSource dataSourceSql()   {
		ComboPooledDataSource dataSourceEf = new ComboPooledDataSource();

		try {
			dataSourceEf.setDriverClass(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
			dataSourceEf.setJdbcUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
			dataSourceEf.setUser(env.getRequiredProperty(PROPERTY_NAME_EF_DATABASE_USERNAME));
			dataSourceEf.setPassword(env.getRequiredProperty(PROPERTY_NAME_EF_DATABASE_PASSWORD));

			dataSourceEf.setMinPoolSize(Integer.valueOf(env.getRequiredProperty(PROPERTY_NAME_DATASOURCE_MINPOOLSIZE)));
			dataSourceEf.setMaxPoolSize(Integer.valueOf(env.getRequiredProperty(PROPERTY_NAME_DATASOURCE_MAXPOOLSIZE)));
			dataSourceEf.setAcquireIncrement(Integer.valueOf(env.getRequiredProperty(PROPERTY_NAME_DATASOURCE_ACQUIREINCREMENT)));
			dataSourceEf.setBreakAfterAcquireFailure(Boolean.valueOf(env.getRequiredProperty(PROPERTY_NAME_DATASOURCE_BREAKAFTERACQUIREFAILURE)));
			dataSourceEf.setMaxIdleTime(Integer.parseInt(env.getRequiredProperty(PROPERTY_NAME_DATASOURCE_MAXIDLETIME)));
		} catch (NumberFormatException|IllegalStateException|PropertyVetoException e) {
			logger.error(e.getMessage(), e);
		}
		
		return dataSourceEf;
	}
 
	
}