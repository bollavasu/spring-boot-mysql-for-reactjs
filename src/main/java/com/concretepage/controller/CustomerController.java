package com.concretepage.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.concretepage.entity.Customer;
import com.concretepage.service.ICustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private ICustomerService customerService;

	@GetMapping("getCustomer/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Integer id) {
		Customer customer = customerService.getCustomerById(id);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	@GetMapping("getAllCustomers")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> list = customerService.getAllCustomers();
		return new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
	}
	@PostMapping("addCustomer")
	public String addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
        return "Customer is created successfully";
	}
	@PutMapping("updateCustomer")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
		customerService.updateCustomer(customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	@DeleteMapping("deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable int id) {
		customerService.deleteCustomer(id);
		return "Customer is deleted successfully";
	}	
	
}
