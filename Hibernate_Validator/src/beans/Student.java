package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Student3", schema="Mas")
public class Student {
	
	@Id
	@Column(name="sid")
	@Min(value=111, message="ID should not be less than 111")
	@Max(value=999, message="ID should be less than 999")
	private int id;
	
	@Column(name="sname")
	@NotEmpty(message="name should not be empty")
	private String name;
	
	@Column(name="semail")
	@NotEmpty(message="email should not be empty")
	@Email(message="Not a valid email	")
	private String email;
	
	@Column(name="saddress")
	@NotEmpty(message="address should not be empty")
	private String address;
	
	@Transient  //if we donot want to insert the marks into the table
	private int marks;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}
	

}
