package in.bhushansirgur.springrestapi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import in.bhushansirgur.springrestapi.model.Employee;

@Controller
@RestController
public class EmployeeController 
{
	@Value("${app.name : Employee Tracker}")
	private String appName;
	
	@Value("${app.version : Advanced Version}")
	private String appVersion;
	
	//localhost:8080/employees
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	@ResponseBody  
	public String getEmployees()
	{
		return "displaying the list of employees";
	}
	
	//localhost:8080/employees/34
	@GetMapping("/firstemployee/{id}")
	public String getFirstEmployees(@PathVariable ("id") int id)
	{
		System.out.println(id);
		return "displaying the first of our employee :  " + id;
	}

	//localhost:8080/employees?id=34
	@DeleteMapping("/firstemployee")
	public String deleteEmployees(@RequestParam("id") int id )
	{
		System.out.println(id);
		return "deleteing the first of our employee :  " + id;
	}
	
	@PostMapping("/employee")
	public String saveEmployees(@RequestBody Employee emp)
	{
		System.out.println(emp);
		System.out.println();
		return "saving the employee details to the database : " + emp.getAge();
	}
	
	@GetMapping("/version")
	public String getAppDetails()
	{
		return appName.toString() + appVersion.toString();
	}
	
	@PutMapping("/update/{id}")
	public String UpdateEmployees(@RequestBody Employee emp, @PathVariable ("id") Long id)
	{
		System.out.println("Original : " + emp.getAge());
		emp.setAge(id);
		System.out.println("Changed : " + emp.getAge());
		return "saving the employee details to the database : " + emp.getAge();
	}
	
}
