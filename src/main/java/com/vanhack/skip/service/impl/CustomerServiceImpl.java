/**
 * 
 */
package com.vanhack.skip.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vanhack.skip.domain.orm.Customer;
import com.vanhack.skip.domain.orm.repository.CustomerRepository;
import com.vanhack.skip.service.CustomerService;

import lombok.AllArgsConstructor;

/**
 * @author Endrigo
 *
 */
@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
	
	private CustomerRepository customerRepository;
	
	public CustomerServiceImpl() {
	}
	
	@Autowired
	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public boolean isValidUser(Customer customer) {
		if (customerRepository.getByEmailPassword(customer.getEmail(), customer.getPassword()) != null) {
			return true;
		}
		return false;
	}

	@Override
	public void save(Customer customer) {
		customerRepository.save(customer);
	}
}
