/**
 * 
 */
package com.vanhack.skip.service;

import com.vanhack.skip.domain.orm.Cousine;

/**
 * @author Endrigo
 *
 */
public interface CousineService {
	Iterable<Cousine> listAll();

	Iterable<Cousine> getByName(String name);
	
	Cousine getById(Integer id);
}
