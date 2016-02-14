package org.demo.multiple_datasources_example.datasources;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 
 * @author Tuomas Törmä
 *
 *	<p>Configure two datasources and jdbctemplate for them</p>
 */
@Configuration
public class DataSources {
	
	@Bean(name = "primary")
	@Primary
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource primaryDataSource() {
	    return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "primaryJdbc")
	public JdbcTemplate primaryJdbcTemplate(@Qualifier("primary")DataSource primary) {
	      return new JdbcTemplate(primary);
	}

	@Bean(name = "secondary")
	@ConfigurationProperties(prefix="spring.secondDatasource")
	public DataSource secondaryDataSource() {
	    return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "secondaryJdbc")
	 public JdbcTemplate secondaryJdbcTemplate(@Qualifier("secondary")DataSource secondary) {
	      return new JdbcTemplate(secondary);
	}

}