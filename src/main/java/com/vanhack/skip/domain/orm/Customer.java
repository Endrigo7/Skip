/**
 * 
 */
package com.vanhack.skip.domain.orm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.vanhack.skip.util.Hash;

/**
 * @author Endrigo
 *
 */
@Entity
public class Customer implements Serializable{
	private static final long serialVersionUID = -4688027254535385238L;
	
	@Id
	private Integer id;
	
	@Column
	@NotNull
	private String email;
	
	@Column
	@NotNull
	private String name;
	
	@Column
	@NotNull
	private String address;
	
	@Column
	private String creation;
	
	@Column
	@NotNull
	private String password;
	
	public Customer() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getCreation() {
		return creation;
	}

	public void setCreation(String creation) {
		this.creation = creation;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = Hash.getHash(password);
	}
}
