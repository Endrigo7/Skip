/**
 * 
 */
package com.vanhack.skip.service;

import com.vanhack.skip.domain.orm.Store;

/**
 * @author Endrigo
 *
 */
public interface StoreService {
	Iterable<Store> listAll();
	
	Iterable<Store> getByName(String name);
	
	Store getById(Integer id);
	
}
