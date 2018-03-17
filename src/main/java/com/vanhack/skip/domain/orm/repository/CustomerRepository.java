/**
 * 
 */
package com.vanhack.skip.domain.orm.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.vanhack.skip.domain.orm.Customer;

/**
 * @author Endrigo
 *
 */
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	
	@Query("SELECT c FROM Customer c WHERE c.email= ? and c.password = ?")
	public Customer getByEmailPassword(String email, String password);
}
