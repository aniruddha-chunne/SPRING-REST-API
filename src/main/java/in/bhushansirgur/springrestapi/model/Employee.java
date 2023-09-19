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
@Entity()
@Table(name = "tbl_employee")
public class Employee {

//	@JsonProperty("Full Name")
	
	@Id
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