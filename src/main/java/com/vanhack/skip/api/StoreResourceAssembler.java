package com.vanhack.skip.api;

import org.springframework.stereotype.Component;

import com.vanhack.skip.domain.orm.Store;

@Component
public class StoreResourceAssembler {
	
	private StoreResource storeResource;
	
	public StoreResourceAssembler() {
	}
	
//	@Autowired
//	public void setStoreResource(StoreResource storeResource) {
//		this.storeResource = storeResource;
//	}

	public StoreResource toResource(Store store) {
		storeResource = new StoreResource();
		
		storeResource.setId(store.getId());
		storeResource.setName(store.getName());
		storeResource.setAddress(store.getAddress());
		storeResource.setCoursineId(store.getCousine().getId());
		
		return storeResource;
	}
}
