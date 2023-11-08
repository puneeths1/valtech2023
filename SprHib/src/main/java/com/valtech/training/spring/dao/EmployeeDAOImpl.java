package com.valtech.training.spring.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.valtech.training.hibernate.Employee;


@Repository 

public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Employee saveEmployee(Employee emp) {
		Session ses = sessionFactory.getCurrentSession();
		ses.persist(emp);
//		ses.close();
		return emp;
	}
	
	@Override
	public Employee loadEmployee(int empid) {
		Session ses = sessionFactory.getCurrentSession();
		Employee emp = (Employee) ses.load(Employee.class, empid);
//		ses.close();
		return emp;
	}
	
	@Override
	public Employee updateEmployee(Employee emp) {
		Session ses = sessionFactory.getCurrentSession();
		emp = (Employee) ses.merge(emp);
//		ses.close();
		return emp;
	}
	
	@Override
	public List<Employee> getAllEmployees(){
		Session ses = sessionFactory.openSession();
		List<Employee> emps = ses.createQuery("from Employee e").list();
//		ses.close();
		return emps;
	}
	
	@Override
	public void deleteEmployee(Employee emp) {
		Session ses = sessionFactory.getCurrentSession();
		ses.delete(emp);
//		ses.close();
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
