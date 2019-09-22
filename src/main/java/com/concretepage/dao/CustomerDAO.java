package com.concretepage.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.concretepage.entity.Customer;

@Transactional
@Repository
public class CustomerDAO implements ICustomerDAO {
	
	@PersistenceContext	
	private EntityManager entityManager;	
	
	@Override
	public Customer getCustomerById(int customerId) {
		return entityManager.find(Customer.class, customerId);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getAllCustomers() {
		String hql = "FROM Customer as cust ORDER BY cust.customerId";
		return (List<Customer>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addCustomer(Customer customer) {
		entityManager.persist(customer);
	}
	@Override
	public void updateCustomer(Customer customer) {
		Customer cust = getCustomerById(customer.getCustomerId());
		cust.setName(customer.getName());
		cust.setAge(customer.getAge());
		cust.setSal(customer.getSal());
		cust.setAddress(customer.getAddress());
		cust.setQualification(customer.getQualification());
		cust.setIsMarried(customer.getIsMarried());
		cust.setGender(customer.getGender());
		entityManager.flush();
	}
	@Override
	public void deleteCustomer(int customerId) {
		entityManager.remove(getCustomerById(customerId));
	}

}
