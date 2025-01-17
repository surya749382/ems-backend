package com.youtube.ems_backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
 
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
//@AllArgsConstructor
//@ToString
@Entity
@Table(name = "employees")// for changing the name in database
public class Employee {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto generate the primary key for the row
	private long id;
	@Column(name = "first_name") //to change the column name in database table as first_name
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "email_id", nullable = false, unique = true)
	private String email;
	
	public Employee(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Employee(long id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	
	
}
