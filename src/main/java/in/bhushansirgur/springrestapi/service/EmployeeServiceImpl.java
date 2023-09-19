package in.bhushansirgur.springrestapi.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import in.bhushansirgur.springrestapi.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService 
{

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		
		System.out.println("we are getEmployees EmployeeService Impl");
		
		return null;
	}

	
		
}
