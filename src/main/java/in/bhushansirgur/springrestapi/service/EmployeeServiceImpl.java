package in.bhushansirgur.springrestapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Override
	public void delete(Long id) {
		
		eRepository.deleteById(id);
		
	}
	
	public Employee updateEmployee(Employee employee)
	{
		return eRepository.save(employee);
	}

	@Override
	public List<Employee> getEmployeesByName(String name) 
	{
		return eRepository.findByName(name);
	}

	@Override
	public List<Employee> getEmployeesByNameandLocation(String name, String Location) {
		// TODO Auto-generated method stub
		return eRepository.findByNameAndLocation(name, Location);
	}

	@Override
	public List<Employee> getEmployeesNameContaining(String keyword) {
		// TODO Auto-generated method stub
		
		return eRepository.findByNameContaining(keyword);
	}

	@Override
	public List<Employee> getEmployeesByNameLike(String keyword) {
		// TODO Auto-generated method stub
		return eRepository.findByNameLike("%" + keyword+ "%");
		
	}

	@Override
	public List<Employee> getEmployeesByNameORLocation(String name, String Location) {

		System.out.println(name + "2");
		System.out.println(Location);

		System.out.println("value:" + eRepository.getEmployeesByNameOrLocation(name, Location));


		return eRepository.getEmployeesByNameOrLocation(name, Location);
	}


}
