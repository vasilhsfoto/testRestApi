package com.company;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.company.dao.JdbcTemplatePersonDao;
import com.company.dao.PersonDao;
import com.company.dao.PersonJdbcDao;
import com.company.service.DefaultService;

public class TestDrive {
	
	public static void main(String[] args) {
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//		
//		DefaultService service = (DefaultService) applicationContext.getBean("defaultService");
//		
//		service.updateService(System.getProperty("firstname"), System.getProperty("lastname"));
	}

	/**
	 * programmatically create a data source using spring DriverManagerDataSource.
	 * This doesn't create any connection pool; it is mainly for testing reasons
	 * If you want to create a data source object use either Tomcat's connection pool
	 * or some 3rd parties connection pool implementations like 3CP0, etc 
	 * @return
	 */
	private static DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setUsername("root");
		dataSource.setPassword("amonra13");
		
		return dataSource;
	}
}
