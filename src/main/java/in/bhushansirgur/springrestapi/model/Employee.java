package in.bhushansirgur.springrestapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
//@Entity()
@jakarta.persistence.Entity()
@Table(name = "tbl_employee")
public class Employee {

//	@JsonProperty("Full Name")
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)  
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private Long age;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "department")
	private String department;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Employee(Long id, String name, Long age, String location, String email, String department) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.location = location;
		this.email = email;
		this.department = department;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", location=" + location + ", email=" + email
				+ ", department=" + department + "]";
	}
	

}


//use mydb;
//
//create table tbl_employee
//(
//	id int not null auto_increment primary key,
//    age int not null,
//    name varchar(255) not null,
//    location varchar(255) not null,
//    email varchar(255),
//    department varchar(255)
//);
//
//insert into employee (age, name, email, location, department)
//values
//( 18, "aniruddha" , "achunne3@gmail.com" , "Nagpur", "electronics" ),
//( 20, "Ajinkya" , "ajinkya@gmail.com" , "Pune", "Medical Representative" )