package in.bhushansirgur.springrestapi.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import in.bhushansirgur.springrestapi.model.Employee;
import in.bhushansirgur.springrestapi.repository.EmployeePaginingRepository;

@Service
public class EmployeeServicePagingImpl implements EmployeeServicePaging 
{

	private EmployeePaginingRepository ePagingRepository;
	
	@Override
	public List<Employee> findAllEmployeeByPaging(int pageNumber, int pageSize) {
		
		Pageable pages = PageRequest.of(pageNumber, pageSize);
		
		return ePagingRepository.findAll(pages).toList(); 
	}
	
	

}
