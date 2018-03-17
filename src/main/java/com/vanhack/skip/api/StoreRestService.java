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
import com.vanhack.skip.domain.orm.Store;
import com.vanhack.skip.service.StoreService;

@RestController
@RequestMapping("api/v1/Store")
public class StoreRestService {

	private StoreService storeService;
	
	private StoreResourceAssembler storeResourceAssembler;
	
	private ProductResourceAssembler productResourceAssembler;
	
	public StoreRestService() {
	}
	
	@Autowired
	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}

	@Autowired
	public void setStoreResourceAssembler(StoreResourceAssembler storeResourceAssembler) {
		this.storeResourceAssembler = storeResourceAssembler;
	}
	
	@Autowired
	public void setProductResourceAssembler(ProductResourceAssembler productResourceAssembler) {
		this.productResourceAssembler = productResourceAssembler;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<StoreResource>> listAll() {

		Iterable<Store> iStores = storeService.listAll();
		if (iStores != null) {
			List<StoreResource> storesResource = new ArrayList<StoreResource>();
			for (Store store : iStores) {
				storesResource.add(storeResourceAssembler.toResource(store));
			}

			return new ResponseEntity<List<StoreResource>>(storesResource, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/search/{searchText}", method = RequestMethod.GET)
	public ResponseEntity<List<StoreResource>> getByName(@PathVariable("searchText") String name) {

		Iterable<Store> iStores = storeService.getByName(name);
		if (iStores != null) {
			List<StoreResource> storesResource = new ArrayList<StoreResource>();
			for (Store store : iStores) {
				storesResource.add(storeResourceAssembler.toResource(store));
			}

			return new ResponseEntity<List<StoreResource>>(storesResource, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<StoreResource> getById(@PathVariable("id") Integer id) {

		Store store = storeService.getById(id);

		if (store == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		StoreResource storeResource = storeResourceAssembler.toResource(store);
		return new ResponseEntity<StoreResource>(storeResource, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}/products", method = RequestMethod.GET)
	public ResponseEntity<List<ProductResource>>  getProductsById(@PathVariable("id") Integer id) {

		Store store = storeService.getById(id);

		if (store == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		if(store.getProducts().size() < 1) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		List<ProductResource> products = new ArrayList<ProductResource>();
		for (Product product : store.getProducts()) {
			ProductResource productResource = productResourceAssembler.toResource(product);
			System.out.println(product);
			System.out.println(productResource);
			
			products.add(productResource);
		}
		
		return new ResponseEntity<List<ProductResource>>(products, HttpStatus.OK);
	}

}
