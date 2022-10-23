package com.greatLearning.CustomerRelationshipManagement.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="customer")
public class Customer {

	// define fields

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	

	@Column(name="firstName")
	private String firstName;


	@Column(name="lastName")
	private String lastName;


	@Column(name="email")
	private String email;
	
	
	public void Customer()
	{
		
	}
	
	public Customer(String firstName, String lastName, String email) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Customer [ firstName=" + firstName + ", lastName=" + lastName + ", email=" + email+ "]";
	}

	
	
}











