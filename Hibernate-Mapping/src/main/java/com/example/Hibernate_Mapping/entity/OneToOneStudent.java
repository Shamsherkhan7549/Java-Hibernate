package com.example.Hibernate_Mapping.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class OneToOneStudent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@OneToOne
	@JoinColumn(name = "address_id")
	private OneToOneAddress oneToOneAddress;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public OneToOneAddress getOneToOneAddress() {
		return oneToOneAddress;
	}

	public void setOneToOneAddress(OneToOneAddress oneToOneAddress) {
		this.oneToOneAddress = oneToOneAddress;
	}

}

