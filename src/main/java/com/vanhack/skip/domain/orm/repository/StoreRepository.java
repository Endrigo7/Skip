/**
 * 
 */
package com.vanhack.skip.domain.orm.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.vanhack.skip.domain.orm.Store;

/**
 * @author Endrigo
 *
 */
public interface StoreRepository extends CrudRepository<Store, Integer> {
	
	@Query("SELECT s FROM Store s WHERE s.name LIKE CONCAT(:name,'%')")
	public Iterable<Store> getByName(@Param("name") String name);
}
