package org.demo.multiple_datasources_example.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.demo.multiple_datasources_example.bean.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Tuomas Törmä
 *
 */
@Repository
public class ExampleRepository {
	
    @Autowired
    @Qualifier("primaryJdbc")
    private JdbcTemplate primaryJdbc;
    
    @Autowired
    @Qualifier("secondaryJdbc")
    private JdbcTemplate secondaryJdbc;
    
    public String getExampleTextFromPrimary(){
    	String SQL = "Custom sql here";
    	
    	Example example = primaryJdbc.queryForObject(SQL, new RowMapper<Example>(){
    		@Override
			public Example mapRow(ResultSet rs, int rowNum) throws SQLException {
				Example example = new Example();
				example.setString(rs.getString(1));
				return example;
			}
    	});
    			
    	return example.getString();
    }
    
    public String getExampleTextFromSecondary(){
    	String SQL = "Custom sql here";
    	
    	Example example = secondaryJdbc.queryForObject(SQL, new RowMapper<Example>(){
    		@Override
			public Example mapRow(ResultSet rs, int rowNum) throws SQLException {
				Example example = new Example();
				example.setString(rs.getString(1));
				return example;
			}
    	});
    			
    	return example.getString();
    }

}
