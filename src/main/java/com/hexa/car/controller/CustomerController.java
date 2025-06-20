package com.hexa.car.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hexa.car.exception.ResourceNotFoundException;
import com.hexa.car.model.Customers;
import com.hexa.car.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping(value="/addCustomer")
	public String addCustomer(@RequestBody Customers customers) {
		return customerService.addCustomer(customers);
	}
	
	@GetMapping(value="/login/{username}/{password}")
	public ResponseEntity<Customers> login(@PathVariable String username,@PathVariable String password) throws ResourceNotFoundException{
		return customerService.loginCustomer(username, password);
	}
	
	@GetMapping(value="/searchByCustId/{customerId}")
	public ResponseEntity<Customers> searchById(@PathVariable int customerId) throws ResourceNotFoundException{
		return customerService.searchCustomerById(customerId);
	}
	@GetMapping(value="/searchByCustomerName/{customerName}")
	public ResponseEntity<Customers> searchByCustomerName(@PathVariable String customerName) throws ResourceNotFoundException{
		return customerService.searchByCustomerName(customerName);
		
	}
	
	@GetMapping(value="/showCustomer")
	public List<Customers> showCustomer(){
		return customerService.showAllCustomerInfo();
	}
		
	}

