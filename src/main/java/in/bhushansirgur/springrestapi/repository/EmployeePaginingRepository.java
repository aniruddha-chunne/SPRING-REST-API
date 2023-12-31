package in.bhushansirgur.springrestapi.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import in.bhushansirgur.springrestapi.model.Employee;

@Repository
public interface EmployeePaginingRepository extends PagingAndSortingRepository<Employee, Long>
{
	List<Employee> findByName(String name);
}
