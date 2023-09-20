package in.bhushansirgur.springrestapi.service;

import java.util.List;

import in.bhushansirgur.springrestapi.model.Employee;

public interface EmployeeService 
{
	
	public List<Employee> getEmployees();
	
	public Employee saveEmployee(Employee emp);
	
	public Employee findById(Long id);
	
}
