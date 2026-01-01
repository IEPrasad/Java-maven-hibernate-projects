package model;

import jakarta.persistence.*;

@Entity
@Table(name = "student")

public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	// This no-args constructor must needed for the hibernate to create an object by
	// retrieving data from the database
	public Student() {

	}

	// This all-args constructor need for create an object by adding details of the
	// student
	public Student(int id, String firstName, String lastName, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	// public getter for id
	public int getId() {
		return id;
	}

	// public setter for id
	public void setId(int id) {
		this.id = id;
	}

	// public getter for first name
	public String getFirstName() {
		return firstName;
	}

	// public setter for first name
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	// public getter for last name
	public String getLastname() {
		return lastName;
	}

	// public setter for last name
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// public getter for email
	public String getEmail() {
		return email;
	}

	// public setter for email
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
}
