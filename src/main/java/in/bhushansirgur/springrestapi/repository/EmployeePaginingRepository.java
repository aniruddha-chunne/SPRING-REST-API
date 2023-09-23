package in.bhushansirgur.springrestapi.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import in.bhushansirgur.springrestapi.model.Employee;

public interface EmployeePaginingRepository extends PagingAndSortingRepository<Employee, Long>
{
	List<Employee> findByName(String name);
}
