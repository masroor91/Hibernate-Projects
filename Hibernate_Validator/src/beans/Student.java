package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Student3", schema="Mas")
public class Student {
	
	@Id
	@Column(name="sid")
	private int id;
	
	@Column(name="sname")
	private String name;
	
	@Column(name="semail")
	private String email;
	
	@Column(name="saddress")
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
