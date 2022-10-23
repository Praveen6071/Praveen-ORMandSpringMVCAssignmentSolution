package com.greatLearning.CustomerRelationshipManagement.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatLearning.CustomerRelationshipManagement.entity.Customer;

@Repository
public class CustomerServiceImpl<Student> implements CustomerService {

	private SessionFactory sessionFactory;

	// create session
	private Session session;

	@Autowired
	CustomerServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}

	}

	@Transactional
	public List<Customer> findAll() {

		Transaction tx = session.beginTransaction();

		// find all the records from the database table
		List<Customer> customer = session.createQuery("from Customer").list();

		tx.commit();

		return customer;
	}

	@Transactional
	public Customer findById(int id) {

		Customer customer = new Customer();

		Transaction tx = session.beginTransaction();

		// find record with Id from the database table
		customer = session.get(Customer.class, id);

		tx.commit();

		return customer;
	}

	@Transactional
	public void save(Customer theCustomer) {

		Transaction tx = session.beginTransaction();

		// save transaction
		session.saveOrUpdate(theCustomer);

		tx.commit();

	}

	@Transactional
	public void deleteById(int customerId) {

		Transaction tx = session.beginTransaction();

		// get transaction
		Customer customer1 = session.get(Customer.class, customerId);

		// delete record
		session.delete(customer1);

		tx.commit();

	}

	
	
		// TODO Auto-generated method stub
		
	

}