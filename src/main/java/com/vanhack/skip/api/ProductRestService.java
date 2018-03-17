package com.vanhack.skip.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vanhack.skip.domain.orm.Product;
import com.vanhack.skip.service.ProductService;

@RestController
@RequestMapping("api/v1/Product")
public class ProductRestService {

	private ProductService productService;
	private ProductResourceAssembler productResourceAssembler;
	
	public ProductRestService() {
	}
	
	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@Autowired
	public void setProductResourceAssembler(ProductResourceAssembler productResourceAssembler) {
		this.productResourceAssembler = productResourceAssembler;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<ProductResource>> listAll() {

		Iterable<Product> iProducts = productService.listAll();
		if (iProducts != null) {
			List<ProductResource> productsResource = new ArrayList<ProductResource>();
			for (Product product : iProducts) {
				productsResource.add(productResourceAssembler.toResource(product));
			}

			return new ResponseEntity<List<ProductResource>>(productsResource, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/search/{searchText}", method = RequestMethod.GET)
	public ResponseEntity<List<ProductResource>> getByName(@PathVariable("searchText") String name) {

		Iterable<Product> iProducts = productService.getByName(name);
		if (iProducts != null) {
			List<ProductResource> productsResource = new ArrayList<ProductResource>();
			for (Product product : iProducts) {
				productsResource.add(productResourceAssembler.toResource(product));
			}

			return new ResponseEntity<List<ProductResource>>(productsResource, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProductResource> getById(@PathVariable("id") Integer id) {

		Product product = productService.getById(id);

		if (product == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		ProductResource productResource = productResourceAssembler.toResource(product);
		return new ResponseEntity<ProductResource>(productResource, HttpStatus.OK);
	}

}
