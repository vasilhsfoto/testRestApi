package com.company.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.company.aspects.MonitorSqlOperations;
import com.company.domain.Person;

@Repository("personJdbcDao")
public class PersonJdbcDao implements PersonDao {
	
	@Autowired
	DataSource dataSource;
	
	@MonitorSqlOperations
	public void createPerson(String firstName, String lastName) {
		Connection con=null;
		try {
			con = dataSource.getConnection();
			
			String sql = "INSERT INTO person (firstname, lastname) VALUES(?,?)";
			
			PreparedStatement prepStm = con.prepareStatement(sql);
			
			prepStm.setString(1, firstName);
			prepStm.setString(2, lastName);
			
			prepStm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(con!=null) {	
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Person> select(String firstname, String astname) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(String firstName, String lastName) {
		// TODO Auto-generated method stub
	}
}
