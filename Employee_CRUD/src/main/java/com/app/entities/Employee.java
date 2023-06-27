package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="emp")
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "password")
public class Employee {
	@Id 
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	@Column(name="first_name",length = 20)
	private String firstName;
	@Column(name="last_name",length = 20)
	private String lastName;
	@Column(length = 50)
	private String email;
	@Column(name="Password",length = 30)
	private String password;
	@Column(name="sal")
	private double salary;
	@Column(name="Department",length = 20)
	private String department;
	public Employee(String firstName, String lastName, String email, String password, double salary,
			String department) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.salary = salary;
		this.department = department;
	}
	

}
