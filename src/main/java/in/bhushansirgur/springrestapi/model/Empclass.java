package in.bhushansirgur.springrestapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import in.bhushansirgur.springrestapi.request.EmpclassRequest;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
//@Entity()
@jakarta.persistence.Entity()
public class Empclass {

//	@JsonProperty("Full Name")
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@JoinColumn(name = "department_id")
	@OneToOne
	private Department department;

	public Empclass(EmpclassRequest req) 
	{
			this.name = req.getName();
			
	}
	
	public Empclass(Department dep) 
	{
			this.department=  dep;
			
	}

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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Empclass() {
		super();
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