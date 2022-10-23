package com.greatLearning.CustomerRelationshipManagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatLearning.CustomerRelationshipManagement.entity.Customer;

@Service
public interface CustomerService {
	public List<Customer> findAll();

	public Customer findById(int id);

	public void save(Customer thecustomer);

	public void deleteById(int customer);


	

}
