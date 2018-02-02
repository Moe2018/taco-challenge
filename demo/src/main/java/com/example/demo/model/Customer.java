package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.example.demo.validation.ValidEmail;
import org.hibernate.validator.constraints.Email;


@Entity
@Table(name = "customer")
public class Customer {

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "firstname", nullable = false)
	@Size(min = 2, max = 50)
	private String firstName;
	
	@Column(name = "lastname", nullable = false)
	@Size(min = 2, max = 50)
	private String lastName;
	
	
	@Column(name = "email", unique = true, nullable = false)
	@Email
	@Size(max = 100)
	private String email;
	
	@Column(name = "phone_number", nullable = false)
	@Size(min = 6, max = 30)
	private String phoneNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}

	public String getFirstName() {


		return firstName;
	}

	public void setFirstName(String firstName) {


		this.firstName = firstName;
	}

	public String getLastName() {


		return lastName;
	}

	public void setLastName(String lastName) {

		this.lastName = lastName;
	}

	public String getEmail() {

		return email;
	}

	public void setEmail(String email) {

		this.email = email;
	}

	public String getPhoneNumber() {


		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {


		this.phoneNumber = phoneNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + "]";
	}
	
	
	
	
}
