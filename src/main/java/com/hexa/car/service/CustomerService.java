package com.hexa.car.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hexa.car.exception.ResourceNotFoundException;
import com.hexa.car.model.Customers;
import com.hexa.car.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public String addCustomer(Customers customers) {
		customerRepository.save(customers);
		return "Customer Record Added Successfully...";
	}
	
	public ResponseEntity<Customers>loginCustomer(String username,String password) throws ResourceNotFoundException{
		Customers customer=customerRepository.findByUsernameAndPassword(username, password);
		if(customer!=null) {
			return new ResponseEntity<>(customer,HttpStatus.OK);
		}
		else {
			throw new ResourceNotFoundException("Invalid User...");
		}
	}
	
	public ResponseEntity<Customers> searchCustomerById(int customerId) throws ResourceNotFoundException{
		Customers customer=customerRepository.findById(customerId).orElseThrow(()-> new ResourceNotFoundException("Customer with Id:"+customerId+"Data not found...") );
		return new ResponseEntity<>(customer,HttpStatus.OK);
	}
	
	public ResponseEntity<Customers> searchByCustomerName(String customerName) throws ResourceNotFoundException{
		Customers customer=customerRepository.findByUsername(customerName);
		if(customer!=null) {
		return new	ResponseEntity<>(customer,HttpStatus.OK);
			
		}
		else {
			throw new ResourceNotFoundException("Customer with this Name not Found...");
		}
		
	}
	public List<Customers> showAllCustomerInfo(){
		return customerRepository.findAll();
		}
}
