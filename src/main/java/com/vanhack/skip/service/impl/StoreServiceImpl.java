/**
 * 
 */
package com.vanhack.skip.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vanhack.skip.domain.orm.Store;
import com.vanhack.skip.domain.orm.repository.StoreRepository;
import com.vanhack.skip.service.StoreService;

import lombok.AllArgsConstructor;

/**
 * @author Endrigo
 *
 */
@Service
@AllArgsConstructor
public class StoreServiceImpl implements StoreService {
	
	private StoreRepository storeRepository;
	
	public StoreServiceImpl() {
	}
	
	@Autowired
	public void setStoreRepository(StoreRepository storeRepository) {
		this.storeRepository = storeRepository;
	}
	
	@Override
	public Iterable<Store> listAll() {
		return storeRepository.findAll();
	}
	
	@Override
	public Iterable<Store> getByName(String name){
		return storeRepository.getByName(name);
	}
	
	@Override
	public Store getById(Integer id) {
		return storeRepository.findOne(id);
	}

	
}
