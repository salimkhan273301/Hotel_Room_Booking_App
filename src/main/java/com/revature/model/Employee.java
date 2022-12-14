package com.revature.model;

import java.util.Objects;

public class Employee {
	private Integer id;
	private String name;
	private String email;
	private Boolean manager;
	private Boolean active;
	private String dept;

	public Employee(Integer id, String name, String email, String dept) {
		this.manager = false;
		this.id = id;
		this.name = name;
		this.email = email;
		this.active = true;
		this.setDept(dept);
	}

	public Employee(Integer id, String name, String email, Boolean manager, String dept) {

		this.id = id;
		this.name = name;
		this.email = email;
		this.manager = manager;
		this.active = true;
		this.setDept(dept);
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getManager() {
		return manager;
	}

	public void setManager(Boolean manager) {
		this.manager = manager;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", manager=" + manager + ", active="
				+ active + ", dept=" + dept + "]";
	}

}
