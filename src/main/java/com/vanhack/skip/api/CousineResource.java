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
public class CousineResource {
	
	private Integer id;
	private String name;
	
	public CousineResource() {
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
}
