package in.bhushansirgur.springrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
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
import in.bhushansirgur.springrestapi.repository.EmployeeRepository;
import in.bhushansirgur.springrestapi.service.EmployeeService;
import in.bhushansirgur.springrestapi.service.EmployeeServiceImpl;
import jakarta.validation.Valid;

@Controller
@RestController
public class EmployeeController 
{
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeRepository eRepository;
	
	private EmployeeServiceImpl employeeServiceImpl; 
	
	@Value("${app.name : Employee Tracker}")
	private String appName;
	
	@Value("${app.version : Advanced Version}")
	private String appVersion;
	
	//localhost:8080/employees
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	@ResponseBody  
	public List<Employee> getEmployees()
	{
		return eRepository.findAll();  
//		return findAll.toString();
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
	public Employee saveEmployees(@RequestBody Employee emp)
	{
		System.out.println(emp);
		System.out.println();

//		return "saving the employee details to the database : " + emp.getAge();
		
		employeeService.getEmployees();
		
		return emp;
	}
	
	@PostMapping("/employeeData")
	public Employee saveEmployeesInDatabase( @Valid  @RequestBody Employee emp)
	{
		System.out.println(emp);
		System.out.println();

//		return "saving the employee details to the database : " + emp.getAge();
		
		Employee saveEmployee = employeeService.saveEmployee(emp);
		
		return saveEmployee;
		
//		{ 
//		    "id" : 11,
//		    "name" : "Aniruddha-20",
//			"age" : 31,
//			"location" : "PUNE-20",
//			"email" : "achunne3@gmail.com-20",
//		    "department" : "JAVA Developer-20"
//
//		}
		
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
	
	@GetMapping("{id}")
	public Employee UpdateEmployees(@PathVariable ("id") Long id)
	{
		return employeeService.findById(id);
	}
	
	@PutMapping("/updatelater/{id}")
	public Employee UpdateEmp(@PathVariable ("id") Long id, @RequestBody Employee emp)
	{
		
		emp.setId(id);
		
		return employeeService.updateEmployee(emp);
	}
	
	@DeleteMapping("{id}")
	public String DeleteEmployees(@PathVariable ("id") Long id)
	{
		employeeService.delete(id);
		
		return "Delete a Employee with Id: " + id;
	}
	
}

