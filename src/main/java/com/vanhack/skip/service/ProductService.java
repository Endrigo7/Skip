package com.vanhack.skip.service;

import com.vanhack.skip.domain.orm.Product;

public interface ProductService {
	Iterable<Product> listAll();

	Iterable<Product> getByName(String name);

	Product getById(Integer id);
}
