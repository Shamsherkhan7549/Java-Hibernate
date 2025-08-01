package com.example.Hibernate_Mapping.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OneToManyEmployee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "department_id")
	private OneToManyDepartment department;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public OneToManyDepartment getDepartment() {
		return department;
	}

	public void setDepartment(OneToManyDepartment department) {
		this.department = department;
	}

	
}
