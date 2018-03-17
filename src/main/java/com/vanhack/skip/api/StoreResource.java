package com.vanhack.skip.api;

import org.springframework.stereotype.Component;

@Component
public class StoreResource {
	private Integer id;
    private String name;
	private String address;
	private Integer coursineId;
	
    public StoreResource() {
	}
    
    public StoreResource(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getCoursineId() {
		return coursineId;
	}

	public void setCoursineId(Integer coursineId) {
		this.coursineId = coursineId;
	}
	
	
}