package com.greatLearning.CustomerRelationshipManagement.controller;

import java.util.List;

import org.hibernate.boot.registry.classloading.spi.ClassLoaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatLearning.CustomerRelationshipManagement.entity.Customer;
import com.greatLearning.CustomerRelationshipManagement.service.CustomerService;

@Controller
@RequestMapping("/Customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	private Object theCustomer;

	// add mapping for "/list"

	@RequestMapping("/list")
	public String listBooks(Model theModel) {
		

		System.out.println("request recieved");
		// get Books from db
		List<Customer> theCustomer = customerService.findAll();

		// add to the spring model
		theModel.addAttribute("Customer", theCustomer);

		return "list-Customer";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Customer theCustomer = new Customer();

		theModel.addAttribute("Customer", theCustomer);

		return "Customer-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {

		// get the Book from the service
		Customer theCustomer = customerService.findById(theId);

		// set Book as a model attribute to pre-populate the form
		theModel.addAttribute("Customer", theCustomer);

		// send over to our form
		return "Customer-form";
	}

	@PostMapping("/save")
	public String saveCustomer(@RequestParam("id") int id,@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email)
	{
		Customer theCustomer;
	
	if(id!=0)
	{
		theCustomer=customerService.findById(id);
			theCustomer.setFirstName(firstName);
			theCustomer.setLastName(lastName);
			theCustomer.setEmail(email);
		
		} else
			theCustomer = new Customer(firstName, lastName, email);
		// save the Customer
		( customerService).save(theCustomer);

		// use a redirect to prevent duplicate submissions
		return "redirect:/Customer/list";

	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("customerId") int theId) {

		// delete the Book
		customerService.deleteById(theId);

		// redirect to /Books/list
		return "redirect:/Customer/list";

	}

}
