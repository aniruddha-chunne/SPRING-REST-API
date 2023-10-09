package in.bhushansirgur.springrestapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import in.bhushansirgur.springrestapi.model.Empclass;
import in.bhushansirgur.springrestapi.model.Employee;

@Repository
public interface EmpclassRepository extends JpaRepository<Empclass, Long>
{

}
