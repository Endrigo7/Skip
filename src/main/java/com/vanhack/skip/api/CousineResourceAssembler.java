/**
 * 
 */
package com.vanhack.skip.api;

import org.springframework.stereotype.Component;

import com.vanhack.skip.domain.orm.Cousine;

/**
 * @author Endrigo
 *
 */
@Component
public class CousineResourceAssembler {
	
	private CousineResource cousineResource;
	
	public CousineResourceAssembler() {
	}
	
	public CousineResource toResource(Cousine cousine) {
		cousineResource = new CousineResource();
		cousineResource.setId(cousine.getId());
		cousineResource.setName(cousine.getName());
		
		return cousineResource;
	}
	
}
