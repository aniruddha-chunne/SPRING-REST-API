package in.bhushansirgur.springrestapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import in.bhushansirgur.springrestapi.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>
//public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long>
{

	List<Employee> findByName(String name);
	
	List<Employee> findByNameAndLocation(String name, String Location);

	List<Employee> findByNameContaining(String name);
	
	List<Employee> findByNameLike(String name);

	@Query("from Employee WHERE name = :name or location = :location")
	List<Employee> getEmployeesByNameOrLocation(@Param("name") String name, @Param("location") String location);

	@Modifying
	@Query("Delete from Employee WHERE name = :name" )
	Integer deleteEmployeesByName(  String name);


}
