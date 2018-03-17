package com.vanhack.skip.domain.orm;
 
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;
 
@Entity
public class Store  implements Serializable{
	private static final long serialVersionUID = 5403369037260718254L;

	public Store() {
	}
	
	@Id
    private Integer id;
	
	@ManyToOne()
	@JoinColumn(name = "cousineId")
	private Cousine cousine;
	
    @Column
    private String name;
    
    @Column
    private String address;
	
    @OneToMany(mappedBy="store")
    private List<Product> products;
	
    @Column
    private String creation;	
    
    @Version
    private Integer version;
    
    public Integer getId() {
		return id;
	}
	
    public void setId(Integer id) {
		this.id = id;
	}
	
	public Cousine getCousine() {
		return cousine;
	}
	
	public void setCousine(Cousine cousine) {
		this.cousine = cousine;
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
	
	public List<Product> getProducts() {
		return products;
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;
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
}