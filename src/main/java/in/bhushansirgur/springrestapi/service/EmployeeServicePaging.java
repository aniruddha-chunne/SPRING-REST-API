package in.bhushansirgur.springrestapi.service;

import java.util.List;

import in.bhushansirgur.springrestapi.model.Employee;

public interface EmployeeServicePaging 
{
	
	public List<Employee> findAllEmployeeByPaging(int pageNumber, int pageSize);

}
