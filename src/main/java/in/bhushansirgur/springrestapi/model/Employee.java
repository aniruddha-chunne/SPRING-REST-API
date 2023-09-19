package in.bhushansirgur.springrestapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

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
public class Employee {

	@JsonProperty("Full Name")
	private String name;
	private Long age;
	
	@JsonIgnore
	private String location;
	private String email;
	private String department;
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