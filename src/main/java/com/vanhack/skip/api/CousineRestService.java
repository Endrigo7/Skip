/**
 * 
 */
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

import com.vanhack.skip.domain.orm.Cousine;
import com.vanhack.skip.domain.orm.Store;
import com.vanhack.skip.service.CousineService;

/**
 * @author Endrigo
 *
 */
@RestController
@RequestMapping("api/v1/Cousine")
public class CousineRestService {

	private CousineService cousineService;
	
	private CousineResourceAssembler cousineResourceAssembler;
	
	private StoreResourceAssembler storeResourceAssembler;
	
	public CousineRestService() {
	}
	
	@Autowired
	public void setCousineService(CousineService cousineService) {
		this.cousineService = cousineService;
	}

	@Autowired
	public void setCousineResourceAssembler(CousineResourceAssembler cousineResourceAssembler) {
		this.cousineResourceAssembler = cousineResourceAssembler;
	}
	
	@Autowired
	public void setStoreResourceAssembler(StoreResourceAssembler storeResourceAssembler) {
		this.storeResourceAssembler = storeResourceAssembler;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<CousineResource>> listAll() {

		Iterable<Cousine> iCousines = cousineService.listAll();
		if (iCousines != null) {
			List<CousineResource> cousinesResource = new ArrayList<CousineResource>();
			for (Cousine cousine : iCousines) {
				cousinesResource.add(cousineResourceAssembler.toResource(cousine));
			}

			return new ResponseEntity<List<CousineResource>>(cousinesResource, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/search/{searchText}", method = RequestMethod.GET)
	public ResponseEntity<List<CousineResource>> getByName(@PathVariable("searchText") String name) {

		Iterable<Cousine> iCousines = cousineService.getByName(name);
		if (iCousines != null) {
			List<CousineResource> cousinesResource = new ArrayList<CousineResource>();
			for (Cousine cousine : iCousines) {
				cousinesResource.add(cousineResourceAssembler.toResource(cousine));
			}

			return new ResponseEntity<List<CousineResource>>(cousinesResource, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/{id}/stores", method = RequestMethod.GET)
	public ResponseEntity<List<StoreResource>>  getStoresById(@PathVariable("id") Integer id) {

		Cousine cousine = cousineService.getById(id);

		if (cousine == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		if(cousine.getStores().size() < 1) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		List<StoreResource> stores = new ArrayList<StoreResource>();
		for (Store store : cousine.getStores()) {
			StoreResource storeResource = storeResourceAssembler.toResource(store);
			
			stores.add(storeResource);
		}
		
		return new ResponseEntity<List<StoreResource>>(stores, HttpStatus.OK);
	}
}
