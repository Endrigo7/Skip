/**
 * 
 */
package com.vanhack.skip.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vanhack.skip.domain.orm.Customer;
import com.vanhack.skip.service.CustomerService;
import com.vanhack.skip.util.Hash;

/**
 * @author Endrigo
 *
 */
@RestController
@RequestMapping("api/v1/Customer")
public class CustomerRestService {

	private CustomerService customerService;

	public CustomerRestService() {
	}

	@Autowired
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<ErrorResource> isValidUser(@RequestParam("email") String email,
			@RequestParam("password") String password) {
		Customer customer = new Customer();
		customer.setEmail(email);
		customer.setPassword(password);

		if (customerService.isValidUser(customer)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		ErrorResource errorResource = new ErrorResource();
		errorResource.setError("User and Password not found.");
		return new ResponseEntity<ErrorResource>(errorResource, HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<String> save(@RequestBody Customer customer) {
		customerService.save(customer);

		String token = Hash.getHash(String.valueOf(customer.getId()));
		token += "." + Hash.getHash(customer.getEmail());
		token += "." + Hash.getHash(customer.getAddress());

		return new ResponseEntity<String>(token, HttpStatus.OK);
	}
}
