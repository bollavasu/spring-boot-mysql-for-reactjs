package com.concretepage.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.concretepage.dao.ICustomerDAO;
import com.concretepage.entity.Customer;

@Service
public class CustomerService implements ICustomerService {
	
	@Autowired
	private ICustomerDAO customerDAO;
	
	@Override
	public Customer getCustomerById(int customerId) {
		Customer obj = customerDAO.getCustomerById(customerId);
		return obj;
	}	
	@Override
	public List<Customer> getAllCustomers(){
		return customerDAO.getAllCustomers();
	}
	@Override
	public void addCustomer(Customer customer){
		customerDAO.addCustomer(customer);
	}
	@Override
	public void updateCustomer(Customer customer) {
		customerDAO.updateCustomer(customer);
	}
	@Override
	public void deleteCustomer(int customerId) {
		customerDAO.deleteCustomer(customerId);
	}

}
