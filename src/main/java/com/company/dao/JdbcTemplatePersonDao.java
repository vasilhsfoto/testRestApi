package com.company.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.company.domain.Person;

@Repository("jdbcTemplatePersonDao")
@Scope("singleton")
public class JdbcTemplatePersonDao implements PersonDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void createPerson(String firstName, String lastName) {
		jdbcTemplate.update("insert into person(firstname, lastname) values(?,?)", new Object[] {firstName, lastName});
	}

	public List<Person> select(String firstname, String lastname) {
		return null;
	}

	public void delete(String firstName, String lastName) {
	}
}
