package com.vanhack.skip.domain.orm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class Product implements Serializable {
	private static final long serialVersionUID = -5192069185626416514L;

	public Product() {
	}

	@Id
	private Integer id;

	@ManyToOne()
	@JoinColumn(name = "storeId")
	private Store store;

	@Column
	private String name;

	@Column
	private String description;

	@Column
	private Double price;
	
	@Version
	private Integer version;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
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