/**
 * 
 */
package com.vanhack.skip.service;

import com.vanhack.skip.domain.orm.Customer;

/**
 * @author Endrigo
 *
 */
public interface CustomerService {
	
	boolean isValidUser(Customer customer);
	
	void save(Customer customer);
}
