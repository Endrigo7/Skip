/**
 * 
 */
package com.vanhack.skip.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vanhack.skip.domain.orm.Cousine;
import com.vanhack.skip.domain.orm.repository.CousineRepository;
import com.vanhack.skip.service.CousineService;

import lombok.AllArgsConstructor;

/**
 * @author Endrigo
 *
 */
@Service
@AllArgsConstructor
public class CousineServiceImpl implements CousineService {
	
	private CousineRepository cousineRepository;
	
	public CousineServiceImpl() {
	}
	
	@Autowired
	public void setCousineRepository(CousineRepository cousineRepository) {
		this.cousineRepository = cousineRepository;
	}

	@Override
	public Iterable<Cousine> listAll() {
		return cousineRepository.findAll();
	}

	@Override
	public Iterable<Cousine> getByName(String name) {
		return cousineRepository.getByName(name);
	}

	@Override
	public Cousine getById(Integer id) {
		return cousineRepository.findOne(id);
	}

}
