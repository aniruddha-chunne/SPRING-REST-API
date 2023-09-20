package in.bhushansirgur.springrestapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import in.bhushansirgur.springrestapi.model.Employee;
import in.bhushansirgur.springrestapi.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService 
{

	@Autowired
	private EmployeeRepository eRepository;
	
	
	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		
		System.out.println("we are getEmployees EmployeeService Impl");
		
		return null;
	}

	@Override
	public Employee saveEmployee(Employee emp) {
		// TODO Auto-generated method stub
		
		return eRepository.save(emp);
	}

	@Override
	public Employee findById(Long id) {

		Optional<Employee> findById = eRepository.findById(id);
//		return null;
		return findById.get();
	}

	
		
}
