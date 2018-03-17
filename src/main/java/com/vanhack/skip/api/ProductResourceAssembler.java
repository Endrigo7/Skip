/**
 * 
 */
package com.vanhack.skip.api;

import org.springframework.stereotype.Component;

import com.vanhack.skip.domain.orm.Product;

/**
 * @author Endrigo
 *
 */
@Component
public class ProductResourceAssembler {
	
	private ProductResource productResource;
	
	public ProductResourceAssembler() {
	}
	
//	@Autowired
//	public void setProductResource(ProductResource productResource) {
//		this.productResource = productResource;
//	}
	
	public ProductResource toResource(Product product) {
		productResource = new ProductResource();
		productResource.setId(product.getId());
		productResource.setStoreId(product.getStore().getId());
		productResource.setName(product.getName());
		productResource.setDescription(product.getDescription());
		productResource.setPrice(product.getPrice());
		
		return productResource;
	}
	

}
