package in.bhushansirgur.springrestapi.service;

import java.util.List;

import in.bhushansirgur.springrestapi.model.Employee;

public interface EmployeeService 
{
	
	public List<Employee> getEmployees();
	
	public Employee saveEmployee(Employee emp);
	
	public Employee findById(Long id);
	
	public void delete(Long id);
	
	public Employee updateEmployee(Employee employee);
	
	public List<Employee> getEmployeesByName(String name);
	
	public List<Employee> getEmployeesByNameandLocation(String name, String Location);
	
	public List<Employee> getEmployeesNameContaining(String keyword);
	
	public List<Employee> getEmployeesByNameLike(String keyword);

	public List<Employee> getEmployeesByNameORLocation(String name, String Location);

}
