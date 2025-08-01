package com.example.Hibernate_Mapping.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class OneToManyDepartment {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String department_name;
	
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	List<OneToManyEmployee> employee;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	


}
