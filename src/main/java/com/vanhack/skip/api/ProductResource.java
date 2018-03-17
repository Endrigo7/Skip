/**
 * 
 */
package com.vanhack.skip.api;

import org.springframework.stereotype.Component;

/**
 * @author Endrigo
 *
 */
@Component
public class ProductResource {
	private Integer id;
	private Integer storeId;
	private String name;
	private String description;
	private Double price;
	
	
	public ProductResource() {
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getStoreId() {
		return storeId;
	}
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return getId() + " : " + getName();
	}
	
	
}
