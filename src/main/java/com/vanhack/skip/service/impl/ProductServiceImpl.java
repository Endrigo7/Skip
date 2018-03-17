/**
 * 
 */
package com.vanhack.skip.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vanhack.skip.domain.orm.Product;
import com.vanhack.skip.domain.orm.repository.ProductRepository;
import com.vanhack.skip.service.ProductService;

import lombok.AllArgsConstructor;

/**
 * @author Endrigo
 *
 */
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
	
	private ProductRepository productRepository;
	
	public ProductServiceImpl() {
	}
	
	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public Iterable<Product> listAll() {
		return productRepository.findAll();
	}

	@Override
	public Iterable<Product> getByName(String name) {
		return productRepository.getByName(name);
	}

	@Override
	public Product getById(Integer id) {
		return productRepository.findOne(id);
	}

}
