package com.vanhack.skip.domain.orm.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.vanhack.skip.domain.orm.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
	
	@Query("SELECT p FROM Product p WHERE p.name LIKE CONCAT(:name,'%')")
	public Iterable<Product> getByName(@Param("name") String name);
	
}
