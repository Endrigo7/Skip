/**
 * 
 */
package com.vanhack.skip.domain.orm;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

/**
 * @author Endrigo
 *
 */
@Entity
public class Cousine implements Serializable {
	private static final long serialVersionUID = 9048220384981899871L;

	@Id
	private Integer id;

	@Column
	private String name;

	@OneToMany(mappedBy = "cousine")
	private List<Store> stores;

	@Column
	private String creation;

	@Version
	private Integer version;

	public Cousine() {
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

	public List<Store> getStores() {
		return stores;
	}

	public void setStores(List<Store> stores) {
		this.stores = stores;
	}

	public String getCreation() {
		return creation;
	}

	public void setCreation(String creation) {
		this.creation = creation;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return getId() + " : " + getName();
	}

}
