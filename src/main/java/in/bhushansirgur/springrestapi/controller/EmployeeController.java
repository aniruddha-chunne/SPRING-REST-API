package in.bhushansirgur.springrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
import in.bhushansirgur.springrestapi.repository.EmployeePaginingRepository;
import in.bhushansirgur.springrestapi.repository.EmployeeRepository;
import in.bhushansirgur.springrestapi.service.EmployeeService;
import in.bhushansirgur.springrestapi.service.EmployeeServiceImpl;
import in.bhushansirgur.springrestapi.service.EmployeeServicePagingImpl;
import jakarta.validation.Valid;

@Controller
@RestController
public class EmployeeController 
{
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeRepository eRepository;
	
	@Autowired
	private EmployeePaginingRepository ePagingRepository;
	
	@Autowired
	private EmployeeServicePagingImpl eServicePagingImpl;
	
	private EmployeeServiceImpl employeeServiceImpl; 
	
	@Value("${app.name : Employee Tracker}")
	private String appName;
	
	@Value("${app.version : Advanced Version}")
	private String appVersion;
	
	//localhost:8080/employees
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	@ResponseBody  
	public ResponseEntity<List<Employee>> getEmployees()
	{	// Https Status  = 200 OK
		return  new ResponseEntity<List<Employee>>( eRepository.findAll(), HttpStatus.OK);  
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
	public ResponseEntity<Employee> saveEmployeesInDatabase( @Valid  @RequestBody Employee emp)
	{
		System.out.println(emp);
		System.out.println();

		// Http Status 201 - HttpStatus.CREATED
//		return "saving the employee details to the database : " + emp.getAge();
		
		Employee saveEmployee = employeeService.saveEmployee(emp);
		
		return  new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
		
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
	public ResponseEntity<Employee> UpdateEmp(@PathVariable ("id") Long id, @RequestBody Employee emp)
	{
		emp.setId(id);
		return new ResponseEntity<Employee> (employeeService.updateEmployee(emp), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> DeleteEmployees(@PathVariable ("id") Long id)
	{
		
		// Http Status 204 - HttpStatus.NO_Content 
		
		employeeService.delete(id);
		
		return new ResponseEntity<>("Delete a Employee with Id: " + id, HttpStatus.NO_CONTENT) ;
	}
	
	@GetMapping("/findbyname/{name}")
	public ResponseEntity<List<Employee>> getEmployeesByName(@PathVariable ("name") String name )
	{	// Https Status  = 200 OK
		return  new ResponseEntity<List<Employee>>( employeeService.getEmployeesByName(name), HttpStatus.OK);  
//		return findAll.toString();
	}


	@GetMapping("/employees/{name}/{location}")
	public ResponseEntity<List<Employee>> getEmployeesByNameOrLocation(@PathVariable ( "name" ) String name, @PathVariable ( "location" ) String location)
	{	// Https Status  = 200 OK

		System.out.println(name + "1");
		System.out.println(location);

		System.out.println("EmployeeLocation");

		return  new ResponseEntity<List<Employee>>( employeeService.getEmployeesByNameORLocation(name, location), HttpStatus.OK);
//		return findAll.toString();
	}


	@GetMapping("/findbynameparam")
	public ResponseEntity<List<Employee>> getEmployeesByName1(@RequestParam ("name") String name)
	{	
		
		//http://localhost:8080/api/v1/findbynameparam?name=Ajinkya
		// Https Status  = 200 OK
		return  new ResponseEntity<List<Employee>>( employeeService.getEmployeesByName(name), HttpStatus.OK);  
//		return findAll.toString();
	}
	
	@GetMapping("/findbynameandlocationparam")
	public ResponseEntity<List<Employee>> getEmployeesByNameAndLocation(@RequestParam ("name") String name, @RequestParam ("location") String location )
	{	
		//http://localhost:8080/api/v1/findbynameandlocationparam?name=aniruddha&location=nagpur
		// Https Status  = 200 OK
		return new ResponseEntity<List<Employee>>( employeeService.getEmployeesByNameandLocation(name, location), HttpStatus.OK);  
		//	return findAll.toString();
	}
	
	
	@GetMapping("/findbynamecontaining/{keyword}")
	public ResponseEntity<List<Employee>> getEmployeesByNameContaining(@PathVariable ("keyword") String keyword)
	{	// Https Status  = 200 OK
		return  new ResponseEntity<List<Employee>>( employeeService.getEmployeesNameContaining(keyword), HttpStatus.OK);  
//		return findAll.toString();
	}
	
	
	@GetMapping("/findbynamelike/{keyword}")
	public ResponseEntity<List<Employee>> getEmployeesByNameLike(@PathVariable ("keyword") String keyword)
	{	// Https Status  = 200 OK
		return  new ResponseEntity<List<Employee>>( employeeService.getEmployeesByNameLike(keyword), HttpStatus.OK);  
//		return findAll.toString();
	}
	
	@GetMapping("/findAllPagination/{pageNumber}/{pageSize}")
	public ResponseEntity<List<Employee>> getEmployeesByPagination(@PathVariable ("pageNumber") int pageNumber, @PathVariable ("pageSize") int pageSize)
	{	// Https Status  = 200 OK
		
		System.out.println("pagenumber === " + pageNumber);
		
		Pageable pages = PageRequest.of(pageNumber, pageSize);
		
		return new ResponseEntity<List<Employee>>( ePagingRepository.findAll(pages).toList(), HttpStatus.OK);
		
//		return new ResponseEntity<List<Employee>>( eServicePagingImpl.findAllEmployeeByPaging(pageNumber, pageSize), HttpStatus.OK);  
//		return findAll.toString();
	}
	
	
}

