package com.company.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.company.dao.PersonDao;

@Service("defaultService")
@Scope("singleton")
public class DefaultServiceImpl implements DefaultService, BeanNameAware, BeanFactoryAware {
	private String beanName;
	private BeanFactory beanFactory;
	
	@Autowired
	@Qualifier("personJdbcDao")
	private PersonDao personDao;
	
	public void updateService(String firstName, String lastName) {
		personDao.createPerson(firstName, lastName);
	}

	public void setBeanName(String name) {
		this.beanName=name;
	}

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory=beanFactory;
	}
}
