package com.company.dao;

import java.util.List;

import javax.sql.DataSource;

import com.company.domain.Person;

public interface PersonDao {
	void createPerson(String firstName, String lastName);
	List<Person> select(String firstname, String astname);
	void delete(String firstName, String lastName);
}
