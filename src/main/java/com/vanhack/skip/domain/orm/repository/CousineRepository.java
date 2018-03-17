package com.vanhack.skip.domain.orm.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.vanhack.skip.domain.orm.Cousine;

public interface CousineRepository extends CrudRepository<Cousine, Integer> {

	@Query("SELECT c FROM Cousine c WHERE c.name LIKE CONCAT(:name,'%')")
	public Iterable<Cousine> getByName(@Param("name") String name);
	
}
